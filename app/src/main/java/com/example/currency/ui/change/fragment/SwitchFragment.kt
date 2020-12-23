package com.example.currency.ui.change.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.currency.R
import com.example.currency.data.model.country.CountryItem
import kotlinx.android.synthetic.main.fragment_switch.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*
import kotlin.collections.ArrayList

class SwitchFragment : Fragment() {
    private val switchViewModel: SwitchViewModel by viewModel()
    lateinit var countryCurrencyAdapter: CountryCurrencyAdapter
    var list: MutableList<CountryItem> = mutableListOf()

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
        search()
    }

    private fun callApi() {
        switchViewModel.getCountry(getString(R.string.api_key))
    }

    private fun search() {
        searchCurrency.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                filterCountries(searchCurrency.text.toString())
                rcvResultCurrency.adapter = countryCurrencyAdapter
            }

        })
    }

    private fun filterCountries(keyWord: String) {
        val searchCountries: ArrayList<CountryItem> = ArrayList()
        for (countryItem in list) {
            if (countryItem.currencyName.toLowerCase(Locale.ROOT).contains(
                    keyWord.toLowerCase(
                        Locale.ROOT
                    )
                )
            ) {
                searchCountries.add(countryItem)
            }
        }
        countryCurrencyAdapter.filterCountries(searchCountries)
    }

    private fun initRecyclerView(list: MutableList<CountryItem>) {
        this.list.addAll(list)
        countryCurrencyAdapter = CountryCurrencyAdapter(this.list) { index, currencyID ->
            switchCountry(currencyID)
        }
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rcvResultCurrency.layoutManager = linearLayoutManager
        rcvResultCurrency.setHasFixedSize(true)
        countryCurrencyAdapter.notifyDataSetChanged()
        rcvResultCurrency.adapter = countryCurrencyAdapter
    }

    private fun switchCountry(currencyID: String) {
        val countryItem = list.find { countryItem ->
            countryItem.id == currencyID
        }
        val intent = Intent()
        val bundle = Bundle()
        val intentResult = activity?.intent
        if (intentResult?.getStringExtra("from") == "from") {
            bundle.putSerializable("test", countryItem)
            bundle.putString("from", "from")
        } else {
            bundle.putSerializable("test", countryItem)
            bundle.putString("to", "to")
        }

        intent.putExtras(bundle)
        activity?.setResult(AppCompatActivity.RESULT_OK, intent)
        activity?.finish()
    }

    private fun setUpViewModel() {
        CoroutineScope(Dispatchers.Main).launch {
            switchViewModel.country.observe(viewLifecycleOwner, {
                initRecyclerView(it)
            })
        }
    }
}