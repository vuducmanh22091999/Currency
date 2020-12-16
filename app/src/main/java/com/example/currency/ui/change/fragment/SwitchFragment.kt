package com.example.currency.ui.change.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currency.R
import com.example.currency.data.model.country.CountryItem
import kotlinx.android.synthetic.main.fragment_switch.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SwitchFragment : Fragment() {
    private val switchViewModel: SwitchViewModel by viewModel()
    lateinit var countryCurrencyAdapter: CountryCurrencyAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_switch, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        callApi()
        setUpViewModel()
    }

    private fun callApi() {
        switchViewModel.getCountry(getString(R.string.api_key))
    }

    private fun initRecyclerView(list: MutableList<CountryItem>) {
        countryCurrencyAdapter = CountryCurrencyAdapter(list)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvResultCurrency.layoutManager = linearLayoutManager
        rcvResultCurrency.setHasFixedSize(true)
        rcvResultCurrency.adapter = countryCurrencyAdapter
    }

    private fun setUpViewModel() {
        CoroutineScope(Dispatchers.Main).launch {
            switchViewModel.country.observe(viewLifecycleOwner, {
                initRecyclerView(it)
            })
        }
    }
}