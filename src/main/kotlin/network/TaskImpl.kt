package network


import model.Task
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*



class TaskImpl(provider: HttpClientProvider):TaskService {
    private val BASE_URL = "http://localhost:8080/tasks"
    private val client = provider.client


    override suspend fun getAllTask(): List<Task> {
        val response = client.get(BASE_URL)
        println(response.bodyAsText())
        return response.body()

    }

    override suspend fun saveTask(task: Task):Task {
       val res = client.post(BASE_URL){
           contentType(ContentType.Application.Json)
           setBody(task)
        }
        return res.body<Task>()

    }

    override suspend fun updateTask(task: Task): Task {
        val response = client.put(BASE_URL+"/${task.id}"){
            contentType(ContentType.Application.Json)
            setBody(task)
        }
        return response.body()
    }

}





