package com.example.todolist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.model.Task
import com.example.todolist.model.repository.TaskRepoImpl

class MainViewModel: ViewModel() {

    private val taskRepo = TaskRepoImpl()

    fun fetchTaskData(): LiveData<MutableList<Task>> {
        val mutableData = MutableLiveData<MutableList<Task>>()
        taskRepo.getTaskData().observeForever { taskList ->
            mutableData.value = taskList
        }

        return mutableData
    }

}