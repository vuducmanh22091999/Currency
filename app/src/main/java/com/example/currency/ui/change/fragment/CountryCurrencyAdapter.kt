package com.example.currency.ui.change.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.currency.R
import com.example.currency.data.model.country.CountryItem
import kotlinx.android.synthetic.main.item_switch_currency.view.*

class CountryCurrencyAdapter (private val listCountry: List<CountryItem>) : RecyclerView.Adapter<CountryCurrencyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun dataBindViewHolder(countryItem: CountryItem) {
            itemView.tvCurrencyId.text = countryItem.currencyId
            itemView.tvCurrencyName.text = countryItem.currencyName
            Glide.with(itemView.context).load(R.drawable.ic_united_states).into(itemView.imgFlagCountry)
            itemView.imgSwitchFrom.setImageResource(R.drawable.ic_right_arrow)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_switch_currency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBindViewHolder(listCountry[position])
    }

    override fun getItemCount(): Int = listCountry.size
}