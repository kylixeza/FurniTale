package com.raion.furnitale.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.raion.furnitale.R
import com.raion.furnitale.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private var _homeBinding: HomeFragmentBinding? = null
    private val homeBinding get() = _homeBinding

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _homeBinding = null
    }

}