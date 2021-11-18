package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*

class AddNewTask : AppCompatActivity() {

    private var database = FirebaseDatabase.getInstance().getReference("tasks")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task)

        val newTask = findViewById<EditText>(R.id.taskDescription)
        val message = "New task has been added! "
        val submitButton = findViewById<Button>(R.id.button_submit)
        val listDisplay = findViewById<TextView>(R.id.listView)

        //show confirmation after add new task
        submitButton.setOnClickListener {
            val description: String = newTask.text.toString()
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()

            // Write a task to the database
            val taskId = database.push().key
            val task = Task(taskId, "user1", description)
            database.child("$taskId").setValue(task)
    }

        // Read list of tasks
        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var lista = StringBuilder()
                var counter = 0;
                for(i in dataSnapshot.children) {
                    counter++
                    var description = i.child("description").getValue()
                    var id = i.child("id").getValue()
                    //lista.append("${i.key} $description $id ")
                    lista.append("$counter $description \n\n")
                }

                //overwrite TextView in AddNewTask layout
                listDisplay.text = lista
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}