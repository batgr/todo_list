package UI

import Task
import TasksManager
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


class TaskViewModel: ViewModel(){

    private var _uiState = MutableStateFlow(TasksManager())
    private var tasks = _uiState.value.tasks
    val uiState:StateFlow<TasksManager> = _uiState.asStateFlow()

    fun addTask(task: Task){
        tasks.add(task)
    }

    fun markAsCompleted(state:Boolean,task: Task){
        _uiState.value.markAsCompleted(state,task)

    }


}