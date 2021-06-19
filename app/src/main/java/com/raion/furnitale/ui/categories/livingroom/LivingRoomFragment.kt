package com.raion.furnitale.ui.categories.livingroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.LivingRoomFragmentBinding
import com.raion.furnitale.utils.ShowState
import org.koin.android.viewmodel.ext.android.viewModel

class LivingRoomFragment : Fragment(), ShowState<LivingRoomFragmentBinding> {

    private val livingRoomViewModel: LivingRoomViewModel by viewModel()
    private var _livingRoomBinding: LivingRoomFragmentBinding? = null
    private val livingRoomBinding get() = _livingRoomBinding
    private lateinit var livingRoomAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _livingRoomBinding = LivingRoomFragmentBinding.inflate(layoutInflater, container, false)
        return livingRoomBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        livingRoomAdapter = activity?.let { CategoryAdapter(it) }!!

        livingRoomBinding?.rvLivingRoom?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = livingRoomAdapter
        }

        livingRoomViewModel.livingRoom.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Success -> {
                    it.data?.let { it1 -> livingRoomAdapter.setAll(it1) }
                    onResourceSuccess(livingRoomBinding)
                }
                is Resource.Loading -> onResourceLoading(livingRoomBinding)
                is Resource.Error -> onResourceFailed(livingRoomBinding, it.message)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _livingRoomBinding = null
    }

    override fun onResourceSuccess(binding: LivingRoomFragmentBinding?) {
        binding?.apply {
            loadingLivingRoom.stop()
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
            rvLivingRoom.visibility = visible
        }
    }

    override fun onResourceFailed(binding: LivingRoomFragmentBinding?, message: String?) {
        binding?.apply {
            loadingLivingRoom.stop()
            rvLivingRoom.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = visible
                tvErrorMessage.text = message?: resources.getText(R.string.message_if_null)
                tvErrorMessage.visibility = visible
            }
        }
    }

    override fun onResourceLoading(binding: LivingRoomFragmentBinding?) {
        binding?.apply {
            loadingLivingRoom.start()
            rvLivingRoom.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
        }
    }
}