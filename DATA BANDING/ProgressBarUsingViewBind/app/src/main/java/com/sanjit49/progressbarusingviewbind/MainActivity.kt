package com.sanjit49.progressbarusingviewbind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.sanjit49.progressbarusingviewbind.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {

            btnRun.setOnClickListener {
               if(progressBar.visibility == View.GONE){
                   progressBar.visibility=View.VISIBLE
                   btnRun.text="Stop"
               }
                else{
                    progressBar.visibility=View.GONE
                   btnRun.text="Start"
               }
            }
        }

    }
}