package com.sanjit49.couroutineconcept

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var mainAcitivityViewModel: MainAcitivityViewModel
    var count=0
    private lateinit var textview2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val ButtonCount = findViewById<Button>(R.id.button2)
        val download = findViewById<Button>(R.id.button)
        textview2 = findViewById<TextView>(R.id.textView2)



        // Below the code  are for checking thread conceppt
// ---------------------------------------------------------------------------------------------------
         ButtonCount.setOnClickListener{
            ++count
            textView.text=count.toString()
        }
        download.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                countThread()
            }
        }
    }
    private  suspend fun countThread(){
        for(i in 1..2000){
            Log.i("mytag","downloading user $i in ${Thread.currentThread().name})")
            withContext(Dispatchers.Main){
                textview2.text="Downloading $i"
            }
            delay(1000)
        }

    }
}