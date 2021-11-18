package com.example.todolist

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    var array = arrayOf("Task1", "Task2", "Task3", "Task4", "Task5")
    private lateinit var listOfItems: ArrayList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val adapter = ArrayAdapter(this,
            R.layout.listview_item, array)

        val listView:ListView = findViewById(R.id.listview_1)
        listView.adapter = adapter

        val addNewActButton = findViewById<Button>(R.id.btn_add_task)
        addNewActButton.setOnClickListener {
            val Intent = Intent(this, AddNewTask::class.java)
            startActivity(Intent)

        }



        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("message")

        myRef.setValue("Hello, World!")


        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.

                listOfItems = ArrayList()
                for(i in snapshot.children) {
                    val newRow = i.getValue(Task::class.java)
                    listOfItems.add(newRow!!)
                }
                setupAdapter(listOfItems)




                val value = snapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }

        })




    }


    private fun setupAdapter(arrayData: ArrayList<Task>) {

        val adapter = ArrayAdapter(this,
            R.layout.listview_item, array)

        val listView:ListView = findViewById(R.id.listview_1)
        listView.adapter = adapter
    }

}