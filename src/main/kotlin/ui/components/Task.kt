package ui.components

import model.Task
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun Task(
    modifier: Modifier = Modifier,
    task: Task,
    onCheckedChange:()->Unit,

    ){

    Card(
        modifier = Modifier.padding(8.dp).size(width = 400.dp, height = 100.dp),
        elevation = 2.dp,
        border = BorderStroke(0.5.dp, Color.Gray),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(modifier = modifier.padding(8.dp)) {
            Row(

            ) {
                RoundedCornerCheckBox(
                    onCheckedChange = {
                        onCheckedChange()
                    },
                    isChecked = task.completed
                )
                Text(task.title, fontWeight = FontWeight.SemiBold, modifier = Modifier.padding(4.dp))
            }
            if(task.completed){
                Text("Completed : ${task.completedAt?.getDateAsText()}")
            }
        }

    }
}