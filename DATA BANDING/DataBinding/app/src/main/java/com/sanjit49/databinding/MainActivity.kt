package com.sanjit49.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjit49.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btn.setOnClickListener {
                val getText=et.text.toString()  // binding.et <- be can also use like this
                tv.text=" Welcome "+getText
                et.setText(" ")

            }
        }

    }
}