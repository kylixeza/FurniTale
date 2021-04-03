package com.raion.furnitale.ui.categories.livingroom

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.LivingRoomFragmentBinding
import com.raion.furnitale.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.living_room_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class LivingRoomFragment : Fragment() {

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
                }

                is Resource.Loading -> {

                }

                is Resource.Error -> {

                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _livingRoomBinding = null
    }
}