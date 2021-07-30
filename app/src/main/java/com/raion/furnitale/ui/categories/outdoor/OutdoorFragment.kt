package com.raion.furnitale.ui.categories.outdoor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.viewbinding.library.fragment.viewBinding
import androidx.recyclerview.widget.GridLayoutManager
import com.raion.furnitale.R
import com.raion.furnitale.core.data.Resource
import com.raion.furnitale.core.ui.CategoryAdapter
import com.raion.furnitale.databinding.OutdoorFragmentBinding
import com.raion.furnitale.utils.ShowState
import org.koin.android.viewmodel.ext.android.viewModel

class OutdoorFragment : Fragment(), ShowState<OutdoorFragmentBinding> {

    private val outdoorViewModel: OutdoorViewModel by viewModel()
    private val outdoorBinding by viewBinding<OutdoorFragmentBinding>()
    private lateinit var outdoorAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.outdoor_fragment, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        outdoorAdapter = activity?.let { CategoryAdapter(it) }!!

        outdoorBinding.rvOutdoor.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = outdoorAdapter
        }

        outdoorViewModel.outdoor.observe(viewLifecycleOwner, {
            when(it) {
                is Resource.Error -> onResourceFailed(outdoorBinding, it.message)
                is Resource.Loading -> onResourceLoading(outdoorBinding)
                is Resource.Success -> {
                    it.data?.let { it1 -> outdoorAdapter.setAll(it1) }
                    onResourceSuccess(outdoorBinding)
                }
            }
        })
    }

    override fun onResourceSuccess(binding: OutdoorFragmentBinding?) {
        binding?.apply {
            loadingOutdoor.stop()
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
            rvOutdoor.visibility = visible
        }
    }

    override fun onResourceFailed(binding: OutdoorFragmentBinding?, message: String?) {
        binding?.apply {
            loadingOutdoor.stop()
            rvOutdoor.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = visible
                tvErrorMessage.text = message?: resources.getText(R.string.message_if_null)
                tvErrorMessage.visibility = visible
            }
        }
    }

    override fun onResourceLoading(binding: OutdoorFragmentBinding?) {
        binding?.apply {
            loadingOutdoor.start()
            rvOutdoor.visibility = gone
            includeDefaultError.apply {
                ivError.visibility = gone
                tvErrorMessage.visibility = gone
            }
        }
    }
}