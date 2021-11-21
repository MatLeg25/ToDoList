package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.model.Task
import com.example.todolist.viewmodel.FirebaseViewModel
import com.example.todolist.viewmodel.MainViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import 	androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:MainAdapter

    val listDisplay = findViewById<TextView>(R.id.listView)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = MainAdapter(this)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerView)


        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = MainAdapter(this)

        val testList = mutableListOf<Task>()
        testList.add(Task("123456","user0","zadanie1"))
        testList.add(Task("123456","user0","zadanie2"))
        testList.add(Task("123456","user0","zadanie3"))

        adapter.setListData(testList)
        adapter.notifyDataSetChanged()

    }


}




//TODO 1. Refactor - code (structure, data flow, code duplications)
//TODO 2. Refactor - layouts (data flow, components reuses)
//TODO 3. To be implemented full CRUD
//TODO 4. Visual improvements