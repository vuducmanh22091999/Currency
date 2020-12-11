package com.example.currency.ui.change.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currency.R
import com.example.currency.ui.change.fragment.SwitchFragment

class ChangeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        supportFragmentManager.beginTransaction().add(R.id.flContentScreen, SwitchFragment())
            .addToBackStack(null).commit()
    }
}