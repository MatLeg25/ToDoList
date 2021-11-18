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

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task)

        val newTask = findViewById<EditText>(R.id.taskDescription)
        val message = "New task has been added! "
        val submitButton = findViewById<Button>(R.id.button_submit)
        val listaDisplay = findViewById<TextView>(R.id.listView)


        //show confirmation after add new task
        submitButton.setOnClickListener {
            val description: String = newTask.text.toString()
            Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()


        // Write a message to the database
        val taskId = database.push().key
        val task = Task(taskId, "user1", description)
        database.child("$taskId").setValue(task)
    }


        database.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var lista = StringBuilder()
                for(i in dataSnapshot.children) {
                    var description = i.child("description").getValue()
                    var id = i.child("id").getValue()
                    //lista.append("${i.key} $description $id ")
                    lista.append("$description \n")
                }

                //overwrite TextView in AddNewTask
                listaDisplay.text = lista

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }


}