package UI

import AppDestinations

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*

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

@Composable
fun AppDestinationCard(
    modifier: Modifier=Modifier,
    appDestinations: AppDestinations,
    currentDestination:AppDestinations,
    onChangeDestination:()->Unit,
    count:Int?=null

    ){
    val cardColor = if(appDestinations==currentDestination) Color(206, 212, 218) else Color.Transparent

    Card(
        modifier = modifier.fillMaxWidth().padding(4.dp),
        backgroundColor = cardColor,
        elevation = 0.dp,
    ) {
        NavigationRailItem(
            icon = {
                IconText(modifier, appDestinations,count)
            },
            onClick = onChangeDestination,
            selected = appDestinations==currentDestination,
            selectedContentColor = Color.Black
        )
    }
}

@Composable
private fun IconText(modifier: Modifier, appDestinations: AppDestinations,count: Int?) {
    Row(
        modifier = modifier.fillMaxWidth()
            .padding(4.dp)
    ) {
        Row(modifier=modifier.weight(1f)) {
            Icon(appDestinations.icon, contentDescription = "")
            Text(appDestinations.title, modifier = modifier.padding(start = 4.dp))
        }
        Text("$count")
    }
}

