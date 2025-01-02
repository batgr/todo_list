package UI

import Task
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class TaskViewModel: ViewModel(){

    private val _tasks = MutableStateFlow<List<Task>>(mutableListOf())


    val tasks:StateFlow<List<Task>> = _tasks.asStateFlow()

    fun addTask(task: Task){
        _tasks.update { (it + task) }

    }

    fun onCheckedChange(task: Task) {

        _tasks.update { it.map { if(it.id==task.id) it.copy(completed = !task.completed) else it}}
    }

    private fun updateTasksState(){
        _tasks.update { it }
    }



}