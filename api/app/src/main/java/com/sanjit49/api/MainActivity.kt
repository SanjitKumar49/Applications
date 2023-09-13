package com.sanjit49.api

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.sanjit49.api.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val url:String= "https://meme-api.com/gimme"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getmemeData()
        binding.button.setOnClickListener {
            getmemeData()
        }
    }
    fun getmemeData(){
         val progresdDialog=ProgressDialog(this)
        progresdDialog.setMessage("please wait 2 sec")
        progresdDialog.show()
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
             Log.e("mytag",response.toString())
                var resoneObject=JSONObject(response)


                resoneObject.get("postLink")

                binding.memeTitile.text=resoneObject.getString("title")
                binding.memeAuthor.text=resoneObject.getString("author")
               // binding.memeImage.setI
                Glide.with(this).load(resoneObject.get("url")).into(binding.memeImage);
                progresdDialog.dismiss()
            },
            { err->
                progresdDialog.dismiss()
                Toast.makeText(this,"${err.localizedMessage}",Toast.LENGTH_LONG).show()
            })

        queue.add(stringRequest)
    }
}