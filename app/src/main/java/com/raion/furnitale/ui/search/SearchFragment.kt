package com.raion.furnitale.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.SearchAdapter
import com.raion.furnitale.databinding.SearchFragmentBinding
import com.raion.furnitale.utils.ShowState
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(), ShowState<SearchFragmentBinding> {

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
    }

    private fun observeSearch() {
        searchViewModel.getSearchProducts(args.query.toString()).observe(viewLifecycleOwner, {
            when (it) {
                is Resource.Error -> onResourceFailed(searchBinding, it.message)
                is Resource.Loading -> onResourceLoading(searchBinding)
                is Resource.Success -> {
                    it.data?.let { it1 -> searchAdapter.setAllData(it1) }
                    onResourceSuccess(searchBinding)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _searchBinding = null
    }

    override fun onResourceSuccess(binding: SearchFragmentBinding?) {
        binding?.apply {
            loadingSearch.stop()
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
            rvSearch.visibility = visible
        }
    }

    override fun onResourceFailed(binding: SearchFragmentBinding?, message: String?) {
        binding?.apply {
            loadingSearch.stop()
            rvSearch.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = visible
                if (message == null)
                    tvErrorMessage.text = resources.getText(R.string.message_if_null)
                else
                    tvErrorMessage.text = message
            }
        }
    }

    override fun onResourceLoading(binding: SearchFragmentBinding?) {
        binding?.apply {
            loadingSearch.start()
            rvSearch.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
        }
    }
}