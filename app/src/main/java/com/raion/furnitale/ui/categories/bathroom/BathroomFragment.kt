package com.raion.furnitale.ui.categories.bathroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.BathroomFragmentBinding
import org.koin.android.viewmodel.ext.android.viewModel

class BathroomFragment : Fragment() {

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
                is Resource.Error -> {
                }
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    it.data?.let { it1 -> bathRoomAdapter.setAll(it1) }
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bathRoomBinding = null
    }
}