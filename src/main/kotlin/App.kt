import UI.*
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
@Preview
fun App(taskViewModel: TaskViewModel= viewModel()) {

    var showDialog by rememberSaveable { mutableStateOf(false) }
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