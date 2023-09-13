package com.sanjit49.recyclearview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView=findViewById<RecyclerView>(R.id.rv)

        val arrContract=ArrayList<User>()
        arrContract.add(User("1","Vandana",R.drawable.vanadna))
        arrContract.add(User("2","Sanjit",R.drawable.sanjit))
        arrContract.add(User("3","Vandana",R.drawable.vanadna))
        arrContract.add(User("4","Sanjit",R.drawable.sanjit))

    recyclerView.layoutManager=GridLayoutManager(this,1)
   val recycleradapter=adapter(this,arrContract)
        recyclerView.adapter=recycleradapter
    }
}