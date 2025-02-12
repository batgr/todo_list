package ui.components

import model.Task
import utils.AppDestinations
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun ListDetailView(
    modifier: Modifier = Modifier,
    onClick:(Boolean)->Unit,
    tasks: List<Task>,
    onCheckedChange:(Task)->Unit
){
    var showSideBar by rememberSaveable{ mutableStateOf(true) }
    val toggleShowSideBar = {showSideBar=!showSideBar}
    var currentDestination by rememberSaveable{ mutableStateOf(AppDestinations.ALL) }

    Row {

        if(showSideBar) SideBar(
            onClick={toggleShowSideBar()},
            currentDestination = currentDestination,
            onChangeDestination = {currentDestination=it},
            tasks=tasks
        )

        Scaffold(
            floatingActionButton = { ButtonAdd(onClick = { onClick(true) }) },
            topBar = {
                CustomTopBar(
                    showNavigationIcon = !showSideBar,
                    onClick = { toggleShowSideBar() }
                )
            },
        ){
            when(currentDestination){
                AppDestinations.ALL -> TasksView(tasks = tasks.filter { !it.completed }, onCheckedChange = {onCheckedChange(it) })
                AppDestinations.COMPLETED -> TasksView(tasks = tasks.filter { it.completed }, onCheckedChange = {onCheckedChange(it) })
            }

        }
    }
}