package com.example.currency.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.currency.R
import com.example.currency.data.model.country.CountryItem
import com.example.currency.ui.change.activity.ChangeActivity
import com.example.currency.ui.change.fragment.SwitchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
    }

    private fun initListener() {
        imgSwitchFrom.setOnClickListener(this)
        imgSwitch.setOnClickListener(this)
    }

    private fun switchActivity() {
        val intent = Intent(this, ChangeActivity::class.java)
        intent.putExtra("from", "from")
        startActivityForResult(intent, 1)
    }

    private fun switchActivityTo() {
        val intent = Intent(this, ChangeActivity::class.java)
        intent.putExtra("to", "to")
        startActivityForResult(intent, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data?.getStringExtra("from") == "from") {
                    data.getSerializableExtra("test")?.let {
                        val countryItem = it as CountryItem
                        tvCurrencyFrom.text = countryItem.currencyId
                        tvDetailsCurrencyFrom.text = countryItem.currencyName
                        tvSymbolCurrencyFrom.text = countryItem.currencySymbol
                    }
                } else if (data?.getStringExtra("to") == "to") {
                    data.getSerializableExtra("test")?.let {
                        val countryItem = it as CountryItem
                        tvCurrencyTo.text = countryItem.currencyId
                        tvDetailsCurrencyTo.text = countryItem.currencyName
                        tvSymbolCurrencyTo.text = countryItem.currencySymbol
                    }
                }
            }
        }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.imgSwitchFrom -> switchActivity()
            R.id.imgSwitch -> switchActivityTo()
        }
    }
}