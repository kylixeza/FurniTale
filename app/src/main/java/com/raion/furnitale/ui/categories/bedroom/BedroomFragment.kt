package com.raion.furnitale.ui.categories.bedroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.BedroomFragmentBinding
import com.raion.furnitale.utils.ShowState
import org.koin.android.viewmodel.ext.android.viewModel

class BedroomFragment : Fragment(), ShowState<BedroomFragmentBinding> {

    private val bedRoomViewModel: BedroomViewModel by viewModel()
    private var _bedRoomBinding: BedroomFragmentBinding? = null
    private val bedRoomBinding get() = _bedRoomBinding
    private lateinit var bedRoomAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bedRoomBinding = BedroomFragmentBinding.inflate(layoutInflater, container, false)
        return bedRoomBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bedRoomAdapter = activity?.let { CategoryAdapter(it) }!!

        bedRoomBinding?.rvBedroom?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bedRoomAdapter
        }

        bedRoomViewModel.bedroom.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Success -> {
                    it.data?.let { it1 -> bedRoomAdapter.setAll(it1) }
                    onResourceSuccess(bedRoomBinding)
                }
                is Resource.Loading -> onResourceLoading(bedRoomBinding)
                is Resource.Error -> onResourceFailed(bedRoomBinding, it.message)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bedRoomBinding = null
    }

    override fun onResourceSuccess(binding: BedroomFragmentBinding?) {
        binding?.apply {
            loadingBedroom.stop()
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
            rvBedroom.visibility = visible
        }
    }

    override fun onResourceFailed(binding: BedroomFragmentBinding?, message: String?) {
        binding?.apply {
            loadingBedroom.stop()
            rvBedroom.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = visible
                tvErrorMessage.text = message?: resources.getText(R.string.message_if_null)
                tvErrorMessage.visibility = visible
            }
        }
    }

    override fun onResourceLoading(binding: BedroomFragmentBinding?) {
        binding?.apply {
            loadingBedroom.start()
            rvBedroom.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
        }
    }
}