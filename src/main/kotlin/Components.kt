import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
@Preview
fun ButtonAdd(modifier: Modifier = Modifier, onClick:()->Unit){
    ExtendedFloatingActionButton(
        onClick=onClick,
        icon = { Icon(Icons.Filled.Add,"") },
        text = { Text("Add task") },
        backgroundColor = Color.Black,
        contentColor = Color.White,

        )
}

@Composable
@Preview
fun CreationTaskDialog(modifier: Modifier=Modifier, onDismiss:()->Unit, onConfirm:(String)->Unit){
    var value by rememberSaveable { mutableStateOf("") }
    Dialog(
        onDismissRequest = onDismiss,
    ){
        Card {
            Column(modifier=modifier.padding(24.dp)) {
                Text("Create new task")
                Row(verticalAlignment = Alignment.CenterVertically){
                    Text("title: ")
                    TextField(value=value, onValueChange = {value=it})
                }
                Row(modifier = modifier.fillMaxWidth()) {
                    TextButton(onDismiss){
                        Text("cancel")
                    }
                    TextButton({ onConfirm(value) }){
                        Text("create")

                    }

                }

            }
        }

    }

}