import UI.ButtonAdd
import UI.TaskDialogCreation
import UI.TaskViewModel
import UI.Tasks
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
@Preview
fun App(taskViewModel: TaskViewModel= viewModel()) {

    var showDialog by remember { mutableStateOf(false) }
    val tasksManager by taskViewModel.uiState.collectAsState()
    val tasks = tasksManager.tasks

    MaterialTheme {
        Scaffold(
            floatingActionButton = { ButtonAdd(onClick = { showDialog = true }) },
        ){
            Tasks(tasks = tasks, onCheckedChange = {task,state-> taskViewModel.markAsCompleted(state,task) })

        }
        if (showDialog) TaskDialogCreation(onDismiss = {showDialog=false}, onConfirm = {
            taskViewModel.addTask(Task(it))
            showDialog=false

        })



    }
}