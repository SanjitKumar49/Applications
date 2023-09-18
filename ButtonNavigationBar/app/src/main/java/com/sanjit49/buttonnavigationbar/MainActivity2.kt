package com.sanjit49.buttonnavigationbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjit49.buttonnavigationbar.databinding.ActivityMain2Binding
import com.sanjit49.buttonnavigationbar.databinding.ActivityMainBinding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val name=binding.etName.text.toString()
        binding.btSubmit.setOnClickListener {
            binding.tvResult.text=name
            binding.etName.setText(" ")
        }

    }
}