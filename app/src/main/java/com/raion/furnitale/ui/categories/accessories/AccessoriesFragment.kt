package com.raion.furnitale.ui.categories.accessories

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raion.furnitale.R

class AccessoriesFragment : Fragment() {

    companion object {
        fun newInstance() = AccessoriesFragment()
    }

    private lateinit var viewModel: AccessoriesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.accessories_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AccessoriesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}