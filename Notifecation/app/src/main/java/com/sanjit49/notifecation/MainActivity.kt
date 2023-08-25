package com.sanjit49.notifecation

import android.accounts.AuthenticatorDescription
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.ParcelFileDescriptor
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {
    private val channelID="com.sanjit49.notifecation.channel1"
    private var notificationManger:NotificationManager?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button=findViewById<Button>(R.id.button)
        notificationManger=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChennal(channelID,  "DemoChannel","this is demo")
         button.setOnClickListener {
             dispalyNotifiction()
         }
    }
    private fun dispalyNotifiction(){
        val notificationID=45
        val notification=NotificationCompat.Builder(this@MainActivity,channelID)
            .setContentTitle("DEMO TITLE")
            .setContentText("THIS IS A DEMO NOTIFICATION")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()
        notificationManger?.notify(notificationID,notification)


    }
    private  fun createNotificationChennal(id:String,name:String,chennalDescription: String){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val importance=NotificationManager.IMPORTANCE_HIGH
            val channel=NotificationChannel(id,name,importance).apply {
                description=chennalDescription
            }
            notificationManger?.createNotificationChannel(channel)
        }
    }
}