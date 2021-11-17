package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.IgnoreExtraProperties
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddNewTask : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task)

        val newTask = findViewById<EditText>(R.id.taskDescription)
        val message = "New task added! " + "(" +newTask.text + ")"
        val displayMessage = findViewById<TextView>(R.id.message2)
        var info = "START| "
        val submitButton = findViewById<Button>(R.id.button_submit)


// Write a message to the database
//        var database = FirebaseDatabase.getInstance("https://vax-in-60807-default-rtdb.asia-southeast1.firebasedatabase.app")
//        val myRef = database.getReference("message")
//        myRef.setValue("Hello, World!")



        //////////dwa
//        val ref = FirebaseDatabase.getInstance().getReference("tasks")

//
//        if (taskId != null) {
//            ref.child(taskId).setValue(task).addOnCompleteListener {
//                Toast.makeText(applicationContext, "Task added!", Toast.LENGTH_SHORT).show()
//            }
//        }


        //show confirmation after add new task
        submitButton.setOnClickListener {
            // your code to perform when the user clicks on the button
            displayMessage.text = newTask.text
            val toast1 = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
            toast1.setGravity(Gravity.CENTER,0,0)
            toast1.show()
        }

        // Write a message to the database
        val database = Firebase.database
        val myRef = database.getReference("task")

        myRef.setValue("Zadanie1")


    }
}