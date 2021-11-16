package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AddNewTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task)

        val newTask = findViewById<EditText>(R.id.taskDescription)
        val message = "New task added! " + "(" +newTask.text + ")"
        val displayMessage = findViewById<TextView>(R.id.message2)
        var info = "START| "
        val submitButton = findViewById<Button>(R.id.button_submit)
        // set on-click listener
        submitButton.setOnClickListener {
            // your code to perform when the user clicks on the button
            displayMessage.text = newTask.text
            val toast1 = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT)
            toast1.setGravity(Gravity.CENTER,0,0)
            toast1.show()
        }



    }
}