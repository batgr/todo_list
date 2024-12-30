import java.util.Objects

class Task(var title:String="") {
     var completed:Boolean=false
     var id:Int=ID.count()
          get() = field

     private object ID{
          var id=0
          fun count() = id++
     }


     override fun hashCode(): Int {
          return id
     }

     override fun equals(other: Any?): Boolean {
          if (this === other) return true
          if (other !is Task) return false

          if (title != other.title) return false

          return true
     }


}



