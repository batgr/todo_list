package UI

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
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
fun CustomTextField(
    modifier: Modifier=Modifier,
    value:String,
    onValueChange:(String)->Unit){
    OutlinedTextField(value=value, onValueChange = {onValueChange(it)})
}

@Composable
fun CustomTextButton(
    modifier: Modifier=Modifier,
    text:String,
    onClick: () -> Unit,
    enabled: Boolean=true
    ){

    TextButton(
        onClick = onClick,
        enabled = enabled
        ){
        Text(text)

    }
}