package com.example.currency.ui.change.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.currency.R
import com.example.currency.data.model.test.Test
import kotlinx.android.synthetic.main.item_switch_currency.view.*

class TestAdapter(private val test: List<Test>): RecyclerView.Adapter<TestAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bindData(test: Test) {
            itemView.tvCurrencyId.text = test.results.AD.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_switch_currency, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = test.size
}