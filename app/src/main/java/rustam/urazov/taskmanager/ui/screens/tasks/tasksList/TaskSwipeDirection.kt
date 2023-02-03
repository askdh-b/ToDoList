package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.ui.graphics.Color
import rustam.urazov.taskmanager.ui.theme.Green
import rustam.urazov.taskmanager.ui.theme.Red

enum class TaskSwipeDirection(val color: Color) {
    Delete(Red),
    Initial(Color.Transparent),
    Done(Green)
}