import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*

@Composable
@Preview
fun App() {
    var showDialog by remember { mutableStateOf(false) }
    val tasks = mutableListOf<String>()

    MaterialTheme {
        Scaffold(
            floatingActionButton = { ButtonAdd(onClick = { showDialog = true }) },
        ){
            Tasks(tasks = tasks)

        }

        if (showDialog) CreationTaskDialog(onDismiss = {showDialog=false}, onConfirm = {
            tasks.add(it)
            showDialog=false
        })

    }
}