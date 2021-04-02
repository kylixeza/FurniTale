package com.raion.furnitale.ui.categories.outdoor

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raion.furnitale.R

class OutdoorFragment : Fragment() {

    companion object {
        fun newInstance() = OutdoorFragment()
    }

    private lateinit var viewModel: OutdoorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.outdoor_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(OutdoorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}