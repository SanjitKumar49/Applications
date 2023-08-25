package com.sanjit49.firstprojectinkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val mes=findViewById<TextView >(R.id.textView)
        val value=intent.getStringExtra("first")
        mes.text=value
    }
}