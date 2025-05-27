package com.opp.cashingapi.ui.products.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.opp.cashingapi.databinding.ItemViewProductListBinding
import com.opp.cashingapi.domain.entity.Product
import com.opp.cashingapi.ui.products.adapter.ProductListAdapter.ProductListViewHolder

class ProductListAdapter(val productSelection: (Product) -> Unit) : ListAdapter<Product, ProductListViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemViewProductListBinding.inflate(inflater, parent, false)
        return ProductListViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ProductListViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    object DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean =
            oldItem.id == newItem.id


        override fun areContentsTheSame(
            oldItem: Product,
            newItem: Product
        ): Boolean =
            oldItem == newItem
    }

    inner class ProductListViewHolder(private val binding: ItemViewProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.executePendingBindings()
            binding.root.setOnClickListener {
                productSelection(product)
            }
        }
    }
}