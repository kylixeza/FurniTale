package com.raion.furnitale.ui.search

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.SearchAdapter
import com.raion.furnitale.databinding.SearchFragmentBinding
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private var _searchBinding: SearchFragmentBinding? = null
    private val searchBinding get() = _searchBinding
    private val searchViewModel: SearchViewModel by viewModel()
    private val args: SearchFragmentArgs by navArgs()
    private val searchAdapter: SearchAdapter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        _searchBinding = SearchFragmentBinding.inflate(layoutInflater, container, false)
        return searchBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchBinding?.rvSearch?.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = searchAdapter
        }
        observeSearch()
        Log.d("Search Debug", args.query.toString())
        Log.d("Search Debug", searchAdapter.searchList.toString())
    }

    private fun observeSearch() {
        searchViewModel.getSearchProducts(args.query.toString()).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> searchAdapter.setAllData(it1) }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _searchBinding = null
    }
}