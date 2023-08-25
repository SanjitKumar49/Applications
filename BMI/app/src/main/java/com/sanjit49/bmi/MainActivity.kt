package com.sanjit49.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weight=findViewById<EditText>(R.id.etweight)
        val height=findViewById<EditText>(R.id.etHeight)
        val submit=findViewById<Button>(R.id.button)



        submit.setOnClickListener(View.OnClickListener {
            val getWeight=weight.text.toString()
            val getHeight=height.text.toString()
            if (validdateInput(getWeight,getHeight)) {
                val bmi = getWeight.toFloat() / ((getHeight.toFloat() / 100) * (getHeight.toFloat() / 100))//wight/height*2 if height in a cm then you convert into meter like 1/100 =00.1 meter
                val bmi2Digits = String.format("%.2f", bmi).toFloat()
                dispalyResult(bmi2Digits)
            }
        })

    }
    private  fun validdateInput(weight: String?,height:String?):Boolean{
        return when{
            weight.isNullOrEmpty()->{
                Toast.makeText(this,"Weight is empty",Toast.LENGTH_LONG).show()
                return false
            }
            height.isNullOrEmpty()->{
                Toast.makeText(this,"Height is empty",Toast.LENGTH_LONG).show()
                return false
            }
            else->{
                return  true
            }
        }
    }
    @SuppressLint("SetTextI18n")
    private  fun dispalyResult(bmi:Float){
        val resultIndex=findViewById<TextView>(R.id.tvindex)
        val resultDescription=findViewById<TextView>(R.id.tvresult)
        val info=findViewById<TextView>(R.id.tvinfo)

          resultIndex.text=bmi.toString()
        info.text="Nomral range is: 18.5–24.9"
        var resultText=""
        var color=0
        when{
            bmi<18.50 ->{
                resultText="Under Weight"
                color=R.color.under_weight
            }
            bmi in 18.50..24.99 ->{
                resultText="Healthy"
                color=R.color.normal
            }
            bmi in 25.00..29.99 ->{
                resultText="Over Weight"
                color=R.color.over_weigth
            }
            bmi > 29.99->{
                resultText="Obese"
                color=R.color.obese
            }
        }
        resultDescription.setTextColor(ContextCompat.getColor(this,color))
        resultDescription.text=resultText
    }
}