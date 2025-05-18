package com.opp.cashingapi.ui.components

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.opp.cashingapi.R
import com.opp.cashingapi.utils.toIndianLocaleCurrency

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    if (!url.isNullOrEmpty()) {
        Glide.with(view.context)
            .load(url)
            .centerCrop()
            .into(view)
    }
}

@BindingAdapter("priceText")
fun TextView.setPriceText(value: Double?) {
    value?.let {
        val formattedString=it.toIndianLocaleCurrency()
        text = context.getString(R.string.price_format, formattedString)
    }
}