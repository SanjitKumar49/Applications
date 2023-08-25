package com.sanjit49.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text=findViewById<TextView>(R.id.textView)

        val retService:AlbumService=RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData:LiveData<Response<Album>> = liveData {
            val response=retService.getAlbums()
            emit(response)
        }
        responseLiveData.observe(this, Observer {
           val albumList  =it.body()?.listIterator()
            if (albumList!=null){
                while (albumList.hasNext()){
                    val albumItem=albumList.next()
                    val result = " "+"Album id :${albumItem.id}"+"\n"

                    text.append(result)
                }
            }
        })

    }
}