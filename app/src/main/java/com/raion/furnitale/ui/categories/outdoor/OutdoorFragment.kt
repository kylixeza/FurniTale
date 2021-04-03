package com.raion.furnitale.ui.categories.outdoor

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
import com.raion.furnitale.databinding.OutdoorFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class OutdoorFragment : Fragment() {

    private val outdoorViewModel: OutdoorViewModel by viewModel()
    private var _outdoorBinding: OutdoorFragmentBinding? = null
    private val outdoorBinding get() = _outdoorBinding
    private lateinit var outdoorAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _outdoorBinding = OutdoorFragmentBinding.inflate(layoutInflater, container, false)
        return outdoorBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        outdoorAdapter = activity?.let { CategoryAdapter(it) }!!

        outdoorBinding?.rvOutdoor?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = outdoorAdapter
        }

        outdoorViewModel.outdoor.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> {}
                is Resource.Loading -> {}
                is Resource.Success -> {
                    it.data?.let { it1 -> outdoorAdapter.setAll(it1) }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _outdoorBinding = null
    }
}