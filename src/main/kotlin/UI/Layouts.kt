package UI

import AppDestinations
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import Task
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog


@Composable
fun CustomTopBar(
    modifier: Modifier=Modifier,
    title:String="Tasks",
    showNavigationIcon:Boolean,
    onClick: () -> Unit
){
    TopAppBar(
        title = { Text(title) },
        backgroundColor = Color.White,
        elevation = 0.dp,
        navigationIcon = {
            if(showNavigationIcon){
                IconButton(onClick = onClick) {
                    Icon(Icons.Default.Menu, contentDescription = "Toggle Drawer")
                }
            }
        }
    )
}

@Composable
fun SideBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    currentDestination:AppDestinations,
    onChangeDestination:(AppDestinations)->Unit,
    tasks: List<Task>
    ) {
    NavigationRail(
        modifier = modifier.width(300.dp),
        elevation = 1.dp,
        backgroundColor = Color(233, 236, 239),
        header = {
            IconButton(onClick = onClick, modifier = modifier.align(Alignment.End)){
                Icon(imageVector = Icons.Filled.Menu,"Toggle Drawer")
            }
        },

    ){

       AppDestinations.entries.forEach {
           var count:Int?=null

           if (it==AppDestinations.ALL){
               count=tasks.filter { !it.completed }.size
           }
           if (it==AppDestinations.COMPLETED){
               count=tasks.filter { it.completed }.size
           }

           AppDestinationCard(
               appDestinations = it,
               currentDestination = currentDestination,
               onChangeDestination = {onChangeDestination(it)},
               count=count
           )
       }

    }
}

@Composable
fun ListDetailView(
    modifier: Modifier=Modifier,
    onClick:(Boolean)->Unit,
    tasks: List<Task>,
    onCheckedChange:(Task)->Unit
    ){
    var showSideBar by rememberSaveable{mutableStateOf(true)}
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
                AppDestinations.ALL ->Tasks(tasks = tasks.filter { !it.completed }, onCheckedChange = {onCheckedChange(it) })
                AppDestinations.COMPLETED ->Tasks(tasks = tasks.filter { it.completed }, onCheckedChange = {onCheckedChange(it) })
            }

        }
    }
}

@Composable
private fun Task(
    modifier: Modifier = Modifier,
    task: Task,
    onCheckedChange:()->Unit,

){

    Card(
        modifier = Modifier.padding(8.dp).size(width = 400.dp, height = 100.dp),
        elevation = 2.dp,
        border = BorderStroke(0.5.dp, Color.Gray),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = modifier.padding(8.dp),
        ) {
            RoundedCornerCheckBox(
                onCheckedChange = {
                    onCheckedChange()
                },
                checkedState = task.completed
            )
            Text(task.title, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(4.dp))
        }

    }
}

@Composable
fun Tasks(
    modifier: Modifier = Modifier,
    tasks:List<Task>,
    onCheckedChange:(Task)->Unit
){
    LazyColumn(modifier=modifier.padding(48.dp)) {
        items(items = tasks){
            Task(
                task = it,
                onCheckedChange={ onCheckedChange(it) },
            )
        }
    }
}

@Composable
fun TaskDialogCreation(modifier: Modifier = Modifier, onDismiss:()->Unit, onConfirm:(String)->Unit){

    var title by rememberSaveable { mutableStateOf("") } //the title of the task
    var enabled by rememberSaveable{ mutableStateOf(false) } //enabled or not the button create
    enabled = title.isNotBlank()

    Dialog(
        onDismissRequest = onDismiss,
    ){
        Card {
            Column(
                modifier=modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Create new task", fontWeight = FontWeight.Bold)

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ){
                    Text("title: ")
                    CustomTextField(value=title, onValueChange = {title=it}) //the text field of the title
                }
                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    CustomTextButton(text = "cancel", onClick =onDismiss )
                    CustomTextButton(text = "create", onClick ={ onConfirm(title) }, enabled = enabled )

                }

            }
        }

    }

}
