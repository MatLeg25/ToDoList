package com.example.todolist.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todolist.model.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class TaskRepoImpl(

) : ITaskRepository {
    override suspend fun getTaskById(taskId: String): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun saveTask(description: String): String {
        TODO("Not yet implemented")
    }

    override suspend fun getTasks(dataSnapshot: DataSnapshot): String {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(task: Task): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task): List<Task> {
        TODO("Not yet implemented")
    }


    fun getTaskData(): LiveData<MutableList<Task>> {
        val mutableData = MutableLiveData<MutableList<Task>>()
        FirebaseFirestore.getInstance().collection("Tasks").get().addOnSuccessListener {result ->
            val listData = mutableListOf<Task>()
            for(document in result) {
                val id = document.getString("id")
                val description = document.getString("description")
                val username = document.getString("username")
                val task = Task(id!!, username!!, description!!)
                listData.add(task)
            }

            mutableData.value = listData
        }

        return mutableData
    }

}