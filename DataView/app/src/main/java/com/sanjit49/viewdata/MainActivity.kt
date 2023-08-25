package com.sanjit49.viewdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjit49.viewdata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
        binding.apply {
            button.setOnClickListener{
                val name=etname.text.toString()
                tvresult.text="Welcome: "+name
                etname.text=null
            }
        }
    }
}