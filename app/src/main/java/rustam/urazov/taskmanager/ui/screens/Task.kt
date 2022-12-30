package rustam.urazov.taskmanager.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import rustam.urazov.taskmanager.R
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
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Column(modifier = Modifier) {
                Text(text = task.name, color = Black, style = Typography.h1)
            }
            Column(modifier = Modifier.fillMaxWidth().defaultMinSize(minWidth = 56.dp), horizontalAlignment = Alignment.End) {
                val deadlineInfoEnabled = remember { mutableStateOf(false) }
                Box(modifier = Modifier.clip(CircleShape)) {
                    Image(modifier = Modifier.clickable { deadlineInfoEnabled.value = !deadlineInfoEnabled.value }, painter = painterResource(id = R.drawable.ic_baseline_access_time_24), contentDescription = null, alpha = 0.25f)
                }
                if (deadlineInfoEnabled.value) Text(text = task.deadline, color = Black, style = Typography.body1)
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
                Task(task = TaskView("Выйти из дома", ">24ч", "asdads"))
            }
        }
    }
}