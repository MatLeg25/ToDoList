package com.example.todolist.model.repository

import com.example.todolist.model.Task
import com.google.firebase.database.DataSnapshot

interface ITaskRepository {
    suspend fun getTaskById(taskId: String): List<Task>
    suspend fun saveTask(task: String): String
    suspend fun getTasks(dataSnapshot: DataSnapshot): String
    suspend fun deleteTask(task: Task): List<Task>
    suspend fun updateTask(task: Task): List<Task>
}