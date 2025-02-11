package UI.Components

import AppDestinations
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.NavigationRailItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DestinationCard(
    modifier: Modifier = Modifier,
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