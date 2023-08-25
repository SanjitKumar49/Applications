package com.sanjit49.countingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    var count=0
    private  lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)

       val  result=findViewById<TextView>(R.id.result)
        val button=findViewById<Button>(R.id.button)

       // result.text=count.toString()
       // result.text=viewModel.count.toString()  --> for viewmodel
            viewModel.count.observe(this, Observer {
                result.text=it.toString()
            })
        button.setOnClickListener {
//           ++count
//            result.text=count.toString()
            viewModel.updateCount()
            // result.text=viewModel.count.toString()  --> for viewmodel

        }
    }
}