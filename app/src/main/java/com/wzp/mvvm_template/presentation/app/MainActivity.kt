package com.wzp.mvvm_template.presentation.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wzp.mvvm_template.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }
    }
}