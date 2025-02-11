package UI.Model

import java.time.LocalDateTime

data class Task(
     val title:String="",
     val completed:Boolean=false,
     val id:Long= ID.nextId(),
     val completedAt: SimpleDateTime? = null,
     val createdAt:LocalDateTime = LocalDateTime.now()
     ) {

     private object ID{
          private var id=0L
          fun nextId() = id++
     }

}



