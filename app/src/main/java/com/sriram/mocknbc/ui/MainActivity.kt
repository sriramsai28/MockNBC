package com.sriram.mocknbc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sriram.mocknbc.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this@MainActivity.supportActionBar?.hide()
    }
}
