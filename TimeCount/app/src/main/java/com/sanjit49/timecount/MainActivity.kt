package com.sanjit49.timecount

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sanjit49.timecount.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private  var isStarted=false
    private lateinit var serviceIntent: Intent
    private var time=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.stbtn.setOnClickListener {
            startOrStop()
        }
        binding.rsbtn.setOnClickListener {
            reset()
        }
    serviceIntent=Intent(applicationContext,StopWatchService::class.java)
        registerReceiver(updateTime, IntentFilter(StopWatchService.UPDATE_TIME))
    }
    private fun startOrStop(){
        if (isStarted){
            stop()
        }
        else{
            start()
        }
    }
    private fun start(){
        serviceIntent.putExtra(StopWatchService.CURRENT_TIME,time)
        startService(serviceIntent)
       binding.stbtn.text="Stop"
        isStarted=true
    }
    private fun stop(){
        stopService(serviceIntent)
     binding.stbtn.text="Start"
        isStarted=false
    }
    private fun reset(){
      stop()
        time=0.0
        binding.tvTime.text=getFormattedTime(time)

    }
    private val updateTime:BroadcastReceiver=object :BroadcastReceiver(){
        override fun onReceive(context: Context, intent:Intent) {
            time=intent.getDoubleExtra(StopWatchService.CURRENT_TIME,0.0)
            binding.tvTime.text=getFormattedTime(time)

        }

    }
    private fun getFormattedTime(time:Double):String{
        val timeInt=time.roundToInt()
        val hours= timeInt % 86400 / 3600
        val minute= timeInt % 86400 % 3600 / 60
        val second= timeInt % 86400 % 3600 %60
        return String.format("%02d:%02d:%02d",hours,minute,second)
    }
}