package UI

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import Task
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Dialog


@Composable
fun CustomTopBar(
    modifier: Modifier=Modifier,
    title:String="Tasks"
){
    TopAppBar(
        title = { Text(title) },
        backgroundColor = Color.White,
        elevation = 0.dp,
        navigationIcon = {
            if(false){
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Menu, contentDescription = "Toggle Drawer")
                }
            }
        }
    )
}

@Composable
fun SideBar(modifier: Modifier = Modifier) {
    NavigationRail(
        modifier = modifier.width(250.dp),
        elevation = 1.dp,
        backgroundColor = Color(233, 236, 239)
    ){
        IconButton(onClick = {}, modifier = modifier.align(Alignment.End)){
            Icon(imageVector = Icons.Filled.Menu,"Toggle Drawer")
        }

        Column(modifier=modifier.padding(24.dp)){
            Text("not completed")
            Text("completed")
        }

    }
}

@Composable
fun ListDetailView(
    modifier: Modifier=Modifier,
    onClick:(Boolean)->Unit,
    tasks: List<Task>,
    markAsCompleted:(Boolean,Task)->Unit
    ){
    Row {
        SideBar()
        Scaffold(
            floatingActionButton = { ButtonAdd(onClick = { onClick(true) }) },
            topBar = {
                CustomTopBar()
            },
        ){
            Tasks(tasks = tasks, onCheckedChange = {task,state-> markAsCompleted(state,task) })

        }
    }
}

@Composable
private fun Task(
    modifier: Modifier = Modifier,
    task: Task,
    onCheckedChange:(Boolean)->Unit,
){
    var checkState by rememberSaveable{ mutableStateOf(false) }
    Card(
        modifier=Modifier.padding(8.dp).size(width = 400.dp, height = 100.dp),
        elevation = 2.dp,
        border = BorderStroke(0.5.dp,Color.Gray),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier=modifier.padding(8.dp),
        ) {
            RoundedCornerCheckBox(
                onCheckedChange = {
                    onCheckedChange(it)
                    checkState=it },
                checkedState = checkState
            )
            Text(task.title, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(4.dp))
        }

    }
}

@Composable
fun Tasks(
    modifier: Modifier = Modifier,
    tasks:List<Task>,
    onCheckedChange:(Task,Boolean)->Unit
){

    LazyColumn(modifier=modifier.padding(48.dp)) {
        items(items = tasks){
            Task(task = it,onCheckedChange={state->onCheckedChange(it,state) })
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
