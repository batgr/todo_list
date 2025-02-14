package ui.components

import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextButton(
    modifier: Modifier = Modifier,
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