package ui.components

import utils.AppDestinations
import model.Task
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.NavigationRail
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SideBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    currentDestination: AppDestinations,
    onChangeDestination:(AppDestinations)->Unit,
    completedSize:Int,
    incompletedSize:Int

) {
    NavigationRail(
        modifier = modifier.width(300.dp),
        elevation = 1.dp,
        backgroundColor = Color(233, 236, 239),
        header = {
            IconButton(onClick = onClick, modifier = modifier.align(Alignment.End)){
                Icon(imageVector = Icons.Filled.Menu,"Toggle Drawer")
            }
        },

        ){
        var numberOfElement:Int?=null

        AppDestinations.entries.forEach {
            if(it==AppDestinations.ALL) numberOfElement=incompletedSize
            else if (it==AppDestinations.COMPLETED) numberOfElement=completedSize

            DestinationCard(
                appDestinations = it,
                currentDestination = currentDestination,
                onChangeDestination = {onChangeDestination(it)},
                numberOfElement = numberOfElement

            )
        }

    }
}