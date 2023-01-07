package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import rustam.urazov.taskmanager.R
import rustam.urazov.taskmanager.ui.theme.*
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Task(task: TaskView, modifier: Modifier = Modifier) {
    var descriptionEnabled by remember { mutableStateOf(false) }

    BoxWithConstraints {
        val taskSwipeableState = rememberSwipeableState(initialValue = TaskSwipeDirection.Initial)
        val width = maxWidth

        Box(modifier = modifier
            .swipeable(
                state = taskSwipeableState,
                orientation = Orientation.Horizontal,
                anchors = mapOf(
                    0f to TaskSwipeDirection.Initial,
                    -50f to TaskSwipeDirection.Left,
                    50f to TaskSwipeDirection.Right
                ),
                thresholds = { _, _ -> FractionalThreshold(.3f) }
            )
        ) {
            Box(modifier = Modifier
                .offset {
                    IntOffset(
                        x = taskSwipeableState.offset.value.roundToInt(),
                        y = 0
                    )
                }
                .fillMaxWidth()
                .clip(Shapes.large)
                .clickable { descriptionEnabled = !descriptionEnabled }
                .background(White)
                .padding(LargeLargePaddings)
            ) {
                Column(modifier = Modifier.width(width - 40.dp)) {
                    Text(text = task.title, color = Black, style = Typography.h1)

                    if (descriptionEnabled) Text(
                        text = task.description, color = Black, style = Typography.body1
                    )
                }
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                    var deadlineInfoEnabled by remember { mutableStateOf(false) }

                    Box(modifier = Modifier.clip(CircleShape)) {
                        Image(
                            modifier = Modifier.clickable {
                                deadlineInfoEnabled = !deadlineInfoEnabled
                            },
                            painter = painterResource(id = R.drawable.ic_baseline_access_time_24),
                            contentDescription = null,
                            alpha = 0.25f
                        )
                    }

                    if (deadlineInfoEnabled) Text(
                        text = task.deadline, color = Black, style = Typography.body1
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskPreview() {
    TaskManagerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFEEDDEE)) {
            Column {
                Task(task = TaskView("Выйти из дома", ">24ч", "asdads"))
            }
        }
    }
}