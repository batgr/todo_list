import UI.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


@Composable
@Preview
fun App(taskViewModel: TaskViewModel= viewModel()) {

    var showDialog by remember { mutableStateOf(false) }
    val tasks by taskViewModel.tasks.collectAsState()




    MaterialTheme {
        ListDetailView(
            onClick = {showDialog=true},
            onCheckedChange = { task ->taskViewModel.onCheckedChange(task)},
            tasks = tasks,
        )
        if (showDialog) TaskDialogCreation(onDismiss = {showDialog=false}, onConfirm = {
            taskViewModel.addTask(Task(it))
            showDialog=false

        })

    }


}