package UI

import Task
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
private fun Task(
    modifier: Modifier = Modifier,
    task: Task,


    ){
    var checkState by rememberSaveable{ mutableStateOf(false) }

    Card(
        modifier=Modifier.padding(8.dp).size(width = 400.dp, height = 100.dp),
        elevation = 2.dp
        ) {
        Row(modifier=modifier.padding(4.dp),
            verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkState,
                onCheckedChange = { checkState=it  },
                )
            Text(task.title, fontWeight = FontWeight.SemiBold)
        }

    }
}

@Composable
@Preview
fun Tasks(modifier: Modifier = Modifier, tasks:List<Task>){

    LazyColumn {
        items(items = tasks){
            Task(task = it)

        }
    }
}

