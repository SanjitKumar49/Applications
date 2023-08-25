package com.sanjit49.firstprojectinkotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintSet.INVISIBLE

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val MessageView=findViewById<TextView>(R.id.message)
        val NameEnter=findViewById<EditText>(R.id.name)
        val Submit=findViewById<Button>(R.id.submit)
        val Next=findViewById<Button>(R.id.next)
        var mess=""
        Submit.setOnClickListener(View.OnClickListener {
             mess=NameEnter.text.toString()
            if(mess.equals("")){
                Next.visibility=View.INVISIBLE
                Toast.makeText(this.applicationContext, "please enter your name.!",Toast.LENGTH_LONG).show()
            }else{
                val data="Welcome $mess"
                MessageView.text=data
                NameEnter.text.clear()
                Next.visibility=View.VISIBLE
            }

        })

    Next.setOnClickListener(View.OnClickListener {
    val intent = Intent(this,MainActivity2::class.java)
        intent.putExtra("first","WOW 😍 $mess")
        startActivity(intent)
    })
    }
}