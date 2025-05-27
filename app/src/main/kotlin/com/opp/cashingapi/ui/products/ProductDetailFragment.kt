package com.opp.cashingapi.ui.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.opp.cashingapi.databinding.FragmentProductDetailBinding
import com.opp.cashingapi.domain.entity.Product


class ProductDetailFragment : Fragment() {
    private lateinit var product: Product
    private var _binding: FragmentProductDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = requireArguments().getParcelable("product")!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductDetailBinding.inflate(inflater, container, false)
        binding.product = product
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = arguments?.getParcelable<Product>(KEY_PRODUCT)
        binding.product = product

    }

    companion object {
        const val KEY_PRODUCT = "product"
    }
}