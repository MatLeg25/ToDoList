package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AddNewTask : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_task)

        // get reference to button
        val button_submit = findViewById(R.id.button_submit) as Button
        // set on-click listener
        button_submit.setOnClickListener {
            // your code to perform when the user clicks on the button
            Toast.makeText(this@AddNewTask, "New task added!", Toast.LENGTH_SHORT).show()
        }

    }
}