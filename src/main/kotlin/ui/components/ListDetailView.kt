package ui.components

import model.Task
import utils.AppDestinations
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import ui.TaskViewModel

private const val DEFAULT_SHOW_SIDEBAR = true

private val DEFAULT_DESTINATION = AppDestinations.ALL

@Composable
fun ListDetailView(
    modifier: Modifier = Modifier,
    onClick:(Boolean)->Unit,
    taskViewModel: TaskViewModel=TaskViewModel()
){
    var isSidebarVisible by rememberSaveable{ mutableStateOf(DEFAULT_SHOW_SIDEBAR) }
    val toggleSidebarVisibility = {isSidebarVisible=!isSidebarVisible}
    var currentDestination by rememberSaveable{ mutableStateOf(DEFAULT_DESTINATION) }
    val showTopBarNavIcon = !isSidebarVisible

    val tasks by taskViewModel.tasks.collectAsState()
    val incompleted = tasks.filter { !it.completed }
    val completed = tasks.filter { it.completed }


    Row {

        if(isSidebarVisible) SideBar(
            onClick={toggleSidebarVisibility()},
            currentDestination = currentDestination,
            onChangeDestination = {currentDestination=it},
            incompletedSize = incompleted.size,
            completedSize = completed.size
        )

        Scaffold(
            floatingActionButton = { ButtonAdd(onClick = { onClick(DEFAULT_SHOW_SIDEBAR) }) },
            topBar = {
                CustomTopBar(
                    showNavigationIcon = showTopBarNavIcon,
                    onClick = { toggleSidebarVisibility() }
                )
            },
        ){
            ShowDestinationContent(currentDestination,{ taskViewModel.onCheckedChange(it) },completed,incompleted)

        }
    }
}

@Composable
private fun ShowDestinationContent(
    currentDestination: AppDestinations,
    onCheckedChange: (Task) -> Unit,
    completed:List<Task>,
    incompleted:List<Task>
) {
    when (currentDestination) {
        AppDestinations.ALL -> TasksView(tasks = incompleted, onCheckedChange = { onCheckedChange(it) })
        AppDestinations.COMPLETED -> TasksView(tasks = completed, onCheckedChange = { onCheckedChange(it) })
    }
}