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
//        // get reference to button
//        val btn_click_me = findViewById(R.id.btn_add_task) as Button
//        // set on-click listener
//        btn_click_me.setOnClickListener {
//            // your code to perform when the user clicks on the button
//            Toast.makeText(this@MainActivity, "New task added!", Toast.LENGTH_SHORT).show()
//        }
//
//
//        val ll_main = findViewById(R.id.ll_main_layout) as LinearLayout
//
//        // creating the button
//        val button_dynamic = Button(this)
//        // setting layout_width and layout_height using layout parameters
//        button_dynamic.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
//        button_dynamic.text = "Dynamic Button"
//        // add Button to LinearLayout
//        ll_main.addView(button_dynamic)

    }

    /** Called when the user touches the button */
    fun sendMessage(view: View) {
        // Do something in response to button click
    }
}