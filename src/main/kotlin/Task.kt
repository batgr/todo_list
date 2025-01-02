

data class Task(
     val title:String="",
     val completed:Boolean=false,
     val id:Int=ID.count()) {

     private object ID{
          var id=0
          fun count() = id++
     }




}



