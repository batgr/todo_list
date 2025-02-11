package UI

import UI.Model.SimpleDateTime
import UI.Model.Task
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDateTime


class TaskViewModel: ViewModel(){

    private val _tasks = MutableStateFlow<List<Task>>(mutableListOf())
    val tasks:StateFlow<List<Task>> = _tasks.asStateFlow()


    fun addTask(task: Task){
        _tasks.update { (it + task) }
    }

    fun onCheckedChange(task: Task) {
        val completedAt = if(!task.completed) SimpleDateTime(LocalDateTime.now()) else null
        _tasks.update {
            it.map {
                if(it.id==task.id)
                    it.copy(completed = !task.completed, completedAt = completedAt)
                else it
            }
        }
    }







}