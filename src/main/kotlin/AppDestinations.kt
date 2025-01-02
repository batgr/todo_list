import UI.TaskViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector


enum class AppDestinations(
    val title:String,
    val icon:ImageVector,

) {

    ALL("My tasks", Icons.Filled.Home,),
    COMPLETED("Completed",Icons.Filled.Check,);


}