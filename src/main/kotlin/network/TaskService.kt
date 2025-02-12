package network

import model.Task


interface TaskService{
    suspend fun getAllTask():List<Task>
    suspend fun saveTask(task: Task):Task
    suspend fun updateTask(task: Task):Task
}




