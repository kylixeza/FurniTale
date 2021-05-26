package com.raion.furnitale.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.DiscountAdapter
import com.raion.furnitale.core.ui.HomeCategoryAdapter
import com.raion.furnitale.core.ui.NewProductAdapter
import com.raion.furnitale.core.ui.SelectionAdapter
import com.raion.furnitale.databinding.HomeFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _homeBinding: HomeFragmentBinding? = null
    private val homeBinding get() = _homeBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private val selectionAdapter: SelectionAdapter by inject()
    private val newProductAdapter: NewProductAdapter by inject()
    private val discountAdapter: DiscountAdapter by inject()
    private val homeCategoryAdapter: HomeCategoryAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _homeBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return homeBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        homeBinding?.search?.apply {
            queryHint = "Looking For What?"
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (query != null)
                        findNavController().navigate(HomeFragmentDirections.actionHomeDestinationToSearchFragment(query))
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean = false

            })
        }

        homeBinding?.apply {
            rvDiscount.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = discountAdapter
            }

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

            rvHomeCategoryImage.apply {
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                adapter = homeCategoryAdapter
            }
        }
        observeDiscount()
        observeHomeCategory()
        observeSelection()
    }


    private fun observeDiscount() {
        homeViewModel.discount.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> discountAdapter.setData(it1) }
                }
            }
        })
    }

    private fun observeHomeCategory() {
        homeViewModel.categoryImage.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> homeCategoryAdapter.setAllData(it1) }
                }
            }
        })
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
}