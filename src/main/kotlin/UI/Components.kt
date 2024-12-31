package UI

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


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

@Composable
fun RoundedCornerCheckBox(
    modifier: Modifier=Modifier,
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