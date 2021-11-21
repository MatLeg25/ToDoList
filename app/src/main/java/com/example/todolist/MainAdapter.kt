package com.example.todolist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.todolist.model.Task


class MainAdapter(private val context: Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Task>()

    fun setListData(data:MutableList<Task>) {
        dataList=data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.task_row, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val task = dataList[position]
        holder.bindView(task)
    }

    override fun getItemCount(): Int {
        return if(dataList.size > 0) {
            dataList.size
        } else 0
    }


    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        fun bindView(task: Task) {
            //Glide.with(context).load(task.description).into(itemView.findViewById(R.id.txt_desc))
            //itemView.txt_desc.text = task.description
            itemView.findViewById<TextView>(R.id.txt_desc).text = task.description

        }
    }


}