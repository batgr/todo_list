package ui.components

import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    value:String,
    onValueChange:(String)->Unit){
    OutlinedTextField(value=value, onValueChange = {onValueChange(it)})
}