package com.example.currency.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.currency.R
import com.example.currency.ui.change.activity.ChangeActivity
import com.example.currency.ui.change.fragment.SwitchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListener()
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