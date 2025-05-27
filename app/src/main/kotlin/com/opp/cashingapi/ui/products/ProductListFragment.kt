package com.opp.cashingapi.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.opp.cashingapi.databinding.FragmentProductListBinding
import com.opp.cashingapi.presentation.ProductUiState
import com.opp.cashingapi.presentation.ProductViewModel
import com.opp.cashingapi.ui.products.adapter.ProductListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductListFragment : Fragment() {
    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val productListAdapter = ProductListAdapter { product ->
            findNavController().graph.findNode("product_detail")?.let {
                val bundle = Bundle().apply {
                    putParcelable("product", product)
                }
                findNavController().navigate(it.id, bundle)
            }


        }
        binding.productListRv.adapter = productListAdapter
        val dividerItemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        binding.productListRv.addItemDecoration(dividerItemDecoration)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                productViewModel.uiState.collect { state ->
                    when (state) {
                        is ProductUiState.Error -> {

                        }
                        ProductUiState.Loading -> {

                        }
                        is ProductUiState.Success -> {
                            productListAdapter.submitList(state.products)
                        }
                    }
                }
            }
        }

        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()

    }
}