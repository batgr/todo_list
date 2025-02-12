package model




import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.time.LocalDateTime
@Serializable
data class Task(
    val title:String="",
    val completed:Boolean=false,
    val id: Long? =null,
    @Contextual
    val completedAt: SimpleDateTime?=null,
    @Contextual
    val createdAt:LocalDateTime = LocalDateTime.now()
     )



