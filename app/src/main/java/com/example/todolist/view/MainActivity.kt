package com.example.todolist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.viewmodel.MainViewModel
import 	androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MainAdapter
import com.example.todolist.R

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = adapter
        observeData()
    }


    fun observeData() {
        viewModel.fetchTaskData().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

}



//TODO 1. FIX MVVM implementation
//TODO 2. Refactor - layouts (data flow, components reuses)
//TODO 3. To be implemented full CRUD
//TODO 4. Visual improvements