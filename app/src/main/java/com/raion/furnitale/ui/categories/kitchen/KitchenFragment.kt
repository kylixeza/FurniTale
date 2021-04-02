package com.raion.furnitale.ui.categories.kitchen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raion.furnitale.R

class KitchenFragment : Fragment() {

    companion object {
        fun newInstance() = KitchenFragment()
    }

    private lateinit var viewModel: KitchenViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.kitchen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KitchenViewModel::class.java)
        // TODO: Use the ViewModel
    }

}