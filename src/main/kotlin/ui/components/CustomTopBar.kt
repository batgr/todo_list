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

@Composable
fun CustomTopBar(
    modifier: Modifier = Modifier,
    title:String="Tasks",
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
                    Icon(Icons.Default.Menu, contentDescription = "Toggle Drawer")
                }
            }
        }
    )
}