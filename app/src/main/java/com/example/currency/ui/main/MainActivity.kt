package com.example.currency.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.currency.R
import com.example.currency.ui.change.activity.ChangeActivity
import com.example.currency.ui.change.fragment.SwitchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val switchViewModel: SwitchViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
//        Toast.makeText(
//            this,
//            switchViewModel.getCurrency(getString(R.string.api_key), "USD_VND", "y").toString(),
//            Toast.LENGTH_SHORT
//        ).show()
    }

    private fun initListener() {
        imgFlagFrom.setOnClickListener(this)
    }

    private fun switchActivity() {
        val intent = Intent(this, ChangeActivity::class.java)
        startActivity(intent)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.imgFlagFrom -> switchActivity()
        }
    }
}