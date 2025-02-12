package ui

import network.DefaultHttpClientProvider
import network.TaskImpl
import model.SimpleDateTime
import model.Task
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDateTime


class TaskViewModel: ViewModel(){

    private val _tasks = MutableStateFlow<List<Task>>(mutableListOf())
    private val taskImpl = TaskImpl(DefaultHttpClientProvider)
    val tasks:StateFlow<List<Task>> = _tasks.asStateFlow()


    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO) {

            _tasks.update { (it + taskImpl.saveTask(task)) }
        }


    }

    fun onCheckedChange(task: Task) {
        val completedAt = if(!task.completed) SimpleDateTime(LocalDateTime.now()) else null
        val updatedTask = task.copy(completed = !task.completed, completedAt = completedAt)
        viewModelScope.launch(Dispatchers.IO) {
            taskImpl.updateTask(updatedTask)
        }

        _tasks.update {
            it.map {
                if(it.id==updatedTask.id)
                    updatedTask
                else it
            }
        }
    }

    private fun getTasks() {
        viewModelScope.launch(Dispatchers.IO) {
            _tasks.update { taskImpl.getAllTask() }
        }
    }

   init{ getTasks() }







}