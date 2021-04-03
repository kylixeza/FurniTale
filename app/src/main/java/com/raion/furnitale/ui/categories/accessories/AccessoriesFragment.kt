package com.raion.furnitale.ui.categories.accessories

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
import com.raion.furnitale.databinding.AccessoriesFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class AccessoriesFragment : Fragment() {

    private val accessoriesViewModel: AccessoriesViewModel by viewModel()
    private var _accessoriesBinding: AccessoriesFragmentBinding? = null
    private val accessoriesBinding get() = _accessoriesBinding
    private lateinit var accessoriesAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _accessoriesBinding = AccessoriesFragmentBinding.inflate(layoutInflater, container, false)
        return accessoriesBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accessoriesAdapter = activity?.let { CategoryAdapter(it) }!!

        accessoriesBinding?.rvAccessories?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = accessoriesAdapter
        }

        accessoriesViewModel.accessories.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> accessoriesAdapter.setAll(it1) }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _accessoriesBinding = null
    }
}