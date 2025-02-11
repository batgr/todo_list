package UI.Components

import AppDestinations
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun IconText(modifier: Modifier, appDestinations: AppDestinations, count: Int?) {
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