package ui.components

import model.Task
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TasksView(
    modifier: Modifier = Modifier,
    tasks:List<Task>,
    onCheckedChange:(Task)->Unit
){
    LazyColumn(modifier=modifier.padding(48.dp)) {
        items(items = tasks){
            Task(
                task = it,
                onCheckedChange={ onCheckedChange(it) },
            )
        }
    }
}