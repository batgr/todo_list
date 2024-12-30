package UI

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
@Preview
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