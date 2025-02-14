import ui.*
import ui.components.ListDetailView
import ui.components.TaskCreationDialog
import model.Task
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.lifecycle.viewmodel.compose.viewModel



@Composable
@Preview
fun App(taskViewModel: TaskViewModel= viewModel()) {

    var showDialog by rememberSaveable { mutableStateOf(false) }


    MaterialTheme {
        ListDetailView(
            onClick = {showDialog=true}

        )
        if (showDialog) TaskCreationDialog(onDismiss = {showDialog=false}, onConfirm = {
            taskViewModel.addTask(Task(title = it))
            showDialog=false

        })

    }


}