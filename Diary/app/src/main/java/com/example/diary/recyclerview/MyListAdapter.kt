package com.example.diary.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.diary.EditActivity
import com.example.diary.R

class MyListAdapter(private val data: MutableList<Map<String, String>>) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val date = data[position]["date"]
        val text = data[position]["text"]

        holder.itemDate.text = date
        holder.itemText.text = text

        holder.itemView.setOnClickListener{
            it.context.startActivity(
                Intent(it.context, EditActivity::class.java).apply{
                    putExtra("date", date)
                    putExtra("text", text)
                }
            )
        }
    }

}