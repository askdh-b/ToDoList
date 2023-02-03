package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.taskmanager.R
import rustam.urazov.taskmanager.ui.theme.*

@Composable
fun Task(task: TaskView, modifier: Modifier = Modifier) {
    BoxWithConstraints {
        val width = maxWidth

        Row {
            var descriptionEnabled by remember { mutableStateOf(false) }
            var height by remember { mutableStateOf(0.dp) }
            val density = LocalDensity.current

            Box(modifier = modifier
                .width(width)
                .clip(Shapes.large)
                .clickable { descriptionEnabled = !descriptionEnabled }
                .background(White)
                .onSizeChanged {
                    density.run {
                        height = it.height.toDp()
                    }
                }
                .animateContentSize()
                .padding(LargeLargePaddings)
            ) {
                Row {
                    Column(modifier = Modifier.width(width - 56.dp)) {
                        Text(text = task.title, color = Black, style = Typography.h1)

                        if (descriptionEnabled) Text(
                            text = task.description, color = Black, style = Typography.body1
                        )
                    }
                    Column(
                        modifier = Modifier.width(56.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        var deadlineInfoEnabled by remember { mutableStateOf(false) }

                        Box(modifier = Modifier.clip(CircleShape)) {
                            Image(
                                modifier = Modifier.clickable {
                                    deadlineInfoEnabled = !deadlineInfoEnabled
                                },
                                painter = painterResource(id = R.drawable.ic_access_time_24_black),
                                contentDescription = null,
                                alpha = .25f
                            )
                        }

                        if (deadlineInfoEnabled) Text(
                            text = task.deadline, color = Black, style = Typography.body2
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TaskPreview() {
    TaskManagerTheme {
        Surface(modifier = Modifier.fillMaxHeight(), color = Color(0xFFEEDDEE)) {
            Column {
                Task(task = TaskView("asdasdasd", ">24ч", "asdads"))
            }
        }
    }
}