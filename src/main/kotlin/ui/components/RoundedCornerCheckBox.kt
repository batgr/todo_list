package ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RoundedCornerCheckBox(
    modifier: Modifier = Modifier,
    onCheckedChange:(Boolean)->Unit,
    checkedState:Boolean
){
    Surface(modifier=modifier.padding(6.dp)) {
        Box(
            modifier=modifier
                .size(24.dp)
                .border(width = 2.dp, color = Color.Black, shape = RoundedCornerShape(12.dp))
                .clip(CircleShape)
                .toggleable(
                    value = checkedState,
                    onValueChange = onCheckedChange
                )
                .padding(2.dp),
        ){
            if(checkedState){
                Icon(imageVector = Icons.Filled.Check, contentDescription = "checked")
            }
        }
    }
}