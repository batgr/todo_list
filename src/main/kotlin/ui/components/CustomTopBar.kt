package ui.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private const val DEFAULT_TOP_BAR_TITLE = "Tasks"

private const val DRAWER_TOGGLE_DESCRIPTION = "Toggle Drawer"

@Composable

fun CustomTopBar(
    modifier: Modifier = Modifier,
    title:String=DEFAULT_TOP_BAR_TITLE,
    showNavigationIcon:Boolean,
    onClick: () -> Unit
){
    TopAppBar(
        title = { Text(title) },
        backgroundColor = Color.White,
        elevation = 0.dp,
        navigationIcon = {
            if(showNavigationIcon){
                IconButton(onClick = onClick) {
                    Icon(Icons.Default.Menu, contentDescription = DRAWER_TOGGLE_DESCRIPTION)
                }
            }
        }
    )
}