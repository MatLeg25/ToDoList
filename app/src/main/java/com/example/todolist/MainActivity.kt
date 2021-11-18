package com.example.todolist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.*
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity() {

    private var database = FirebaseDatabase.getInstance().getReference("tasks")
    private var emptyListMsg = "No task on your list"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listDisplay = findViewById<TextView>(R.id.listView)

        // Read list of tasks
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var listTask = StringBuilder()
                var counter = 0
                for (i in dataSnapshot.children) {
                    counter++
                    var description = i.child("description").getValue()
                    var id = i.child("id").getValue()
                    listTask.append("$counter. $description \n\n")
                }

                //overwrite TextView in activity_main layout
                if(counter < 1) {
                    listDisplay.text = emptyListMsg
                } else {
                    listDisplay.text = listTask
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


        val addNewActButton = findViewById<Button>(R.id.btn_add_task)
        addNewActButton.setOnClickListener {
            val intent = Intent(this, AddNewTask::class.java)
            startActivity(intent)
        }
    }


}

//TODO 1. Refactor - code (structure, data flow, code duplications)
//TODO 2. Refactor - layouts (data flow, components reuses)
//TODO 3. To be implemented full CRUD
//TODO 4. Visual improvements