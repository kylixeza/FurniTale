package com.raion.furnitale.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.NewProductAdapter
import com.raion.furnitale.core.ui.SelectionAdapter
import com.raion.furnitale.databinding.HomeFragmentBinding
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ViewModelParameter
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.android.viewmodel.koin.getViewModel
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier

class HomeFragment : Fragment() {

    private var _homeBinding: HomeFragmentBinding? = null
    private val homeBinding get() = _homeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val selectionAdapter: SelectionAdapter by inject()
    private val newProductAdapter: NewProductAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _homeBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return homeBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        homeBinding?.apply {
            ibLivingroom.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(0))
            }
            ibBedroom.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(1))
            }
            ibKitchen.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(2))
            }
            ibBathroom.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(3))
            }
            ibOutdoor.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(4))
            }
            ibAccessories.setOnClickListener {
                it.findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToCategoryActivity(5))
            }
        }

        homeBinding?.apply {
            rvProductSelection.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = selectionAdapter
            }

            rvProductSelection2.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = selectionAdapter
            }

            rvNewProduct.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = newProductAdapter
            }
        }

        observeSelection()
    }

    private fun observeSelection() {
        homeViewModel.selection.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> {}
                is Resource.Loading -> {
                    homeBinding?.apply {
                        loadingRvSelection.loadingColor = R.color.color_primary
                        loadingRvSelection2.loadingColor = R.color.color_primary

                        loadingRvSelection.start()
                        loadingRvSelection2.start()
                    }
                }
                is Resource.Success -> {
                    homeBinding?.apply {
                        loadingRvSelection.stop()
                        loadingRvSelection2.stop()
                    }
                    it.data?.let { it1 -> selectionAdapter.setList(it1) }
                }
            }
        })

        homeViewModel.newProduct.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> {}
                is Resource.Loading -> {
                    homeBinding?.apply {
                        loadingRvNew.loadingColor = R.color.color_primary
                        loadingRvNew.start()
                    }
                }
                is Resource.Success -> {
                    it.data?.let { it1 -> newProductAdapter.setList(it1) }
                    homeBinding?.loadingRvNew?.stop()
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeBinding = null
    }

}