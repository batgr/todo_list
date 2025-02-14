package utils
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import ui.TaskViewModel


enum class AppDestinations(
    val title:String,
    val icon:ImageVector,
    val description:String,
    val numberOfElement:Int?=null

) {
    ALL(
        "My tasks",
        Icons.Filled.Home,
        "All tasks",
        ),

    COMPLETED(
        "Completed",
        Icons.Filled.Check,
        "All tasks completed",
        );


}