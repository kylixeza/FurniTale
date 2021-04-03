package com.raion.furnitale.ui.categories.kitchen

import androidx.lifecycle.ViewModelProvider
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
import org.koin.android.viewmodel.ext.android.viewModel

class KitchenFragment : Fragment() {

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
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> kitchenAdapter.setAll(it1) }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _kitchenBinding = null
    }
}