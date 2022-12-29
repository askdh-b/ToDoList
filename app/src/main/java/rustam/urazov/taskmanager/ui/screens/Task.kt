package rustam.urazov.taskmanager.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.taskmanager.ui.theme.*

@Composable
fun Task(task: TaskView) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(Shapes.large)
            .background(White)
            .padding(LargePaddings)
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = task.name, color = Black, style = Typography.h1)
            Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                Text(text = task.deadline, color = Black, style = Typography.body1)
            }
        }

    }
}

@Preview
@Composable
fun Preview() {
    TaskManagerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFEEDDEE)) {
            Column {
                Task(task = TaskView("asdasd", Priority.High, "asdds", "asdads"))
            }
        }
    }
}