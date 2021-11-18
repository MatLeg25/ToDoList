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
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private var database = FirebaseDatabase.getInstance().getReference("tasks")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listDisplay = findViewById<TextView>(R.id.listView)


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


        val addNewActButton = findViewById<Button>(R.id.btn_add_task)
        addNewActButton.setOnClickListener {
            val intent = Intent(this, AddNewTask::class.java)
            startActivity(intent)
        }
    }


}