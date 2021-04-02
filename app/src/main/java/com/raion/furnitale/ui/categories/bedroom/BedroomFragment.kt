package com.raion.furnitale.ui.categories.bedroom

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raion.furnitale.R

class BedroomFragment : Fragment() {

    companion object {
        fun newInstance() = BedroomFragment()
    }

    private lateinit var viewModel: BedroomViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bedroom_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BedroomViewModel::class.java)
        // TODO: Use the ViewModel
    }

}