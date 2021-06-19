package com.raion.furnitale.ui.categories.bathroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.BathroomFragmentBinding
import com.raion.furnitale.utils.ShowState
import org.koin.android.viewmodel.ext.android.viewModel

class BathroomFragment : Fragment(), ShowState<BathroomFragmentBinding> {

    private val bathroomViewModel: BathroomViewModel by viewModel()
    private var _bathRoomBinding: BathroomFragmentBinding? = null
    private val bathRoomBinding get() = _bathRoomBinding
    private lateinit var bathRoomAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bathRoomBinding = BathroomFragmentBinding.inflate(layoutInflater, container, false)
        return bathRoomBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bathRoomAdapter = activity?.let { CategoryAdapter(it) }!!

        bathRoomBinding?.rvBathroom?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = bathRoomAdapter
        }

        bathroomViewModel.bathroom.observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> onResourceFailed(bathRoomBinding, it.message)
                is Resource.Loading -> onResourceLoading(bathRoomBinding)
                is Resource.Success -> {
                    it.data?.let { it1 -> bathRoomAdapter.setAll(it1) }
                    onResourceSuccess(bathRoomBinding)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bathRoomBinding = null
    }

    override fun onResourceSuccess(binding: BathroomFragmentBinding?) {
        binding?.apply {
            loadingBathroom.stop()
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
            rvBathroom.visibility = visible
        }
    }

    override fun onResourceFailed(binding: BathroomFragmentBinding?, message: String?) {
        binding?.apply {
            loadingBathroom.stop()
            rvBathroom.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = visible
                tvErrorMessage.text = message?: resources.getText(R.string.message_if_null)
                tvErrorMessage.visibility = visible
            }
        }
    }

    override fun onResourceLoading(binding: BathroomFragmentBinding?) {
        binding?.apply {
            loadingBathroom.start()
            rvBathroom.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
        }
    }
}