package UI

import Task
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp

@Composable
private fun Task(
    modifier: Modifier = Modifier,
    task: Task,
    onCheckedChange:(Boolean)->Unit,

    ){
    var checkState by rememberSaveable{ mutableStateOf(false) }

    Card(
        modifier=Modifier.padding(8.dp).size(width = 400.dp, height = 100.dp),
        elevation = 2.dp,
        border = BorderStroke(0.5.dp,Color.Gray),
        shape = RoundedCornerShape(12.dp)

        ) {
        Row(modifier=modifier.padding(8.dp),

            ) {
            RoundedCornerCheckBox(

                onCheckedChange = {
                    onCheckedChange(it)
                    checkState=it },
                checkedState = checkState
                )

            Text(task.title, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(4.dp))
        }

    }
}

@Composable
@Preview
fun Tasks(
    modifier: Modifier = Modifier,
    tasks:List<Task>,
    onCheckedChange:(Task,Boolean)->Unit
    ){


    LazyColumn {
        items(items = tasks){
            Task(task = it,onCheckedChange={state->onCheckedChange(it,state) })


        }
    }
}

