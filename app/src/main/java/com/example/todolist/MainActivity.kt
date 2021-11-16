package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

import android.view.ViewGroup
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val addNewActButton = findViewById<Button>(R.id.btn_add_task)
        addNewActButton.setOnClickListener {
            val Intent = Intent(this, AddNewTask::class.java)
            startActivity(Intent)
        }


//        var array = arrayOf("Task1", "Task2", "Task3", "Task4", "Task5")
//
//



    }

}