package com.raion.furnitale.ui.categories.kitchen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.KitchenFragmentBinding
import com.raion.furnitale.utils.ShowState
import org.koin.android.viewmodel.ext.android.viewModel

class KitchenFragment : Fragment(), ShowState<KitchenFragmentBinding> {

    private val kitchenViewModel: KitchenViewModel by viewModel()
    private var _kitchenBinding: KitchenFragmentBinding? = null
    private val kitchenBinding get() = _kitchenBinding
    private lateinit var kitchenAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _kitchenBinding = KitchenFragmentBinding.inflate(layoutInflater, container, false)
        return kitchenBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        kitchenAdapter = activity?.let { CategoryAdapter(it) }!!

        kitchenBinding?.rvKitchen?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = kitchenAdapter
        }

        kitchenViewModel.kitchen.observe(viewLifecycleOwner,  {
            when(it) {
                is Resource.Error -> onResourceFailed(kitchenBinding, it.message)
                is Resource.Loading -> onResourceLoading(kitchenBinding)
                is Resource.Success -> {
                    it.data?.let { it1 -> kitchenAdapter.setAll(it1) }
                    onResourceSuccess(kitchenBinding)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _kitchenBinding = null
    }

    override fun onResourceSuccess(binding: KitchenFragmentBinding?) {
        binding?.apply {
            loadingKitchen.stop()
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
            rvKitchen.visibility = visible
        }
    }

    override fun onResourceFailed(binding: KitchenFragmentBinding?, message: String?) {
        binding?.apply {
            loadingKitchen.stop()
            rvKitchen.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = visible
                tvErrorMessage.text = message ?: resources.getText(R.string.message_if_null)
                tvErrorMessage.visibility = visible
            }
        }
    }

    override fun onResourceLoading(binding: KitchenFragmentBinding?) {
        binding?.apply {
            loadingKitchen.start()
            rvKitchen.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
        }
    }
}