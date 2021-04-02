package com.raion.furnitale.ui.categories.bathroom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raion.furnitale.R

class BathroomFragment : Fragment() {

    companion object {
        fun newInstance() = BathroomFragment()
    }

    private lateinit var viewModel: BathroomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bathroom_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BathroomViewModel::class.java)
        // TODO: Use the ViewModel
    }

}