class TasksManager {
    val tasks:MutableList<Task> = mutableListOf()

    fun markAsCompleted(state:Boolean,task: Task){
        //println("${task.title} ${task.id}avant modification ${task.completed}")
        task.completed=state

        //println("${tasks.get(tasks.indexOf(task)).title} ${tasks.get(tasks.indexOf(task)).id} après modification ${tasks.get(tasks.indexOf(task)).completed}")


    }
}