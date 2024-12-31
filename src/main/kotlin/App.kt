import UI.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
@Preview
fun App(taskViewModel: TaskViewModel= viewModel()) {

    var showDialog by remember { mutableStateOf(false) }
    val tasksManager by taskViewModel.uiState.collectAsState()
    val tasks = tasksManager.tasks

    MaterialTheme {

        ListDetailView(
            onClick = {showDialog=true},
            markAsCompleted = {state,task-> taskViewModel.markAsCompleted(state,task) },
            tasks = tasks,
        )

        if (showDialog) TaskDialogCreation(onDismiss = {showDialog=false}, onConfirm = {
            taskViewModel.addTask(Task(it))
            showDialog=false

        })

    }


}