import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
private fun Task(modifier: Modifier = Modifier, title:String){
    Card {
        Text(title)
    }
}

@Preview
@Composable
fun Tasks(modifier: Modifier = Modifier, tasks:List<String>){
    LazyColumn {
        items(items = tasks){
            Task(title=it)
        }
    }
}