package com.sanjit49.recyclearview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(val context: Context, val arrContext: ArrayList<User>):RecyclerView.Adapter<adapter.ViewHoldr>(){

    class ViewHoldr(itemView:View): RecyclerView.ViewHolder(itemView) {
        val image=itemView.findViewById<ImageView>(R.id.image)
        val name=itemView.findViewById<TextView>(R.id.tv2)
        val id=itemView.findViewById<TextView>(R.id.tv)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoldr {
   return ViewHoldr(LayoutInflater.from(context).inflate(R.layout.customlistview,parent,false))
    }

    override fun getItemCount(): Int {
return arrContext.size
    }

    override fun onBindViewHolder(holder: ViewHoldr, position: Int) {
holder.image.setImageResource(arrContext[position].pic)
        holder.name.text=arrContext[position].name
        holder.id.text=arrContext[position].id
    }
}