package com.example.todolist.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todolist.model.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class TaskRepoImpl(

    private var databaseF: DatabaseReference = FirebaseDatabase.getInstance().getReference("tasks"),
    //val database: FirebaseFirestore = FirebaseFirestore.getInstance(),

) : ITaskRepository {
    override suspend fun getTaskById(taskId: String): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun saveTask(description: String): String {
        val taskId = databaseF.push().key
        val task = Task(taskId, "user1", description)
        databaseF.child("$taskId").setValue(task)
        return "ADDED"
    }

    override suspend fun getTasks(dataSnapshot: DataSnapshot): String {
        var listTask = StringBuilder()
        var counter = 0;
        for (i in dataSnapshot.children) {
            counter++
            var description = i.child("description").getValue()
            var id = i.child("id").getValue()
            //listTask.append("${i.key} $description $id ")
            listTask.append("$counter. $description \n\n")
        }
        return listTask.toString()
    }

    override suspend fun deleteTask(task: Task): List<Task> {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task): List<Task> {
        TODO("Not yet implemented")
    }


    fun getTaskData(): LiveData<MutableList<Task>> {
        val mutableData = MutableLiveData<MutableList<Task>>()
//        FirebaseFirestore.getInstance().collection("Tasks").get().addOnSuccessListener {result ->
//            val listData = mutableListOf<Task>()
//            for(task in result) {
//                val id = "X"//task.getString("id")
//                val description = task.getString("description")
//                val username = task.getString("username")
//                val task = Task(id!!, username!!, description!!)
//                //listData.add(task)
//            }
//
//            mutableData.value = listData
//        }

        return mutableData
    }

}