package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddNewTask : AppCompatActivity() {

    private var database = FirebaseDatabase.getInstance().getReference("tasks")
    private lateinit var listOfItems: ArrayList<Task>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task)

        val newTask = findViewById<EditText>(R.id.taskDescription)
        val message = "New task has been added! "
        val displayMessage = findViewById<TextView>(R.id.message2)
        val submitButton = findViewById<Button>(R.id.button_submit)




        //show confirmation after add new task
        submitButton.setOnClickListener {
            // your code to perform when the user clicks on the button
            val description: String = newTask.text.toString()
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

        // Write a message to the database
        val taskId = database.push().key
        val task = Task(taskId, "user1", description)
        database.child("$taskId").setValue(task)
    }

        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                listOfItems = ArrayList()
                for(i in dataSnapshot.children) {
                    val newRow = i.getValue(Task::class.java)
                    listOfItems.add(newRow!!)
                }
                setupAdapter(listOfItems)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }


    private fun setupAdapter(arrayData: ArrayList<Task>) {
        //recyclerView.adapter = Adapter(arrayData)
    }

}