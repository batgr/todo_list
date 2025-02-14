package ui.components

import androidx.compose.material.ExtendedFloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


import utils.ButtonText

@Composable
fun ButtonAdd(modifier: Modifier = Modifier, onClick:()->Unit){
    ExtendedFloatingActionButton(
        onClick=onClick,
        icon = { Icon(Icons.Filled.Add, ButtonText.ADD_TASK.description) },
        text = { Text(ButtonText.ADD_TASK.title) },
        backgroundColor = Color.Black,
        contentColor = Color.White,

        )
}