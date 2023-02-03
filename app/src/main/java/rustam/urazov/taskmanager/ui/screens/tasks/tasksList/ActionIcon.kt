package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rustam.urazov.taskmanager.R
import rustam.urazov.taskmanager.ui.theme.Green
import rustam.urazov.taskmanager.ui.theme.Shapes
import rustam.urazov.taskmanager.ui.theme.TaskManagerTheme
import rustam.urazov.taskmanager.ui.theme.White

@Composable
fun ActionIcon(
    actionState: ActionState,
    icon: Painter,
    boxSize: Dp,
    offset: Dp
) {
    Box(
        modifier = Modifier
            .size(boxSize)
            .offset(x = offset)
            .clip(Shapes.large)
            .background(actionState.primaryColor)
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            painter = icon,
            contentDescription = null,
            tint = actionState.secondaryColor
        )
    }
}

@Preview
@Composable
fun ActionIconPreview() {
    TaskManagerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFEEDDEE)) {
            Column {
                val actionState = ActionState(Green, White)

                ActionIcon(
                    boxSize = 32.dp,
                    offset = 0.dp,
                    actionState = actionState,
                    icon = painterResource(id = R.drawable.ic_done_24_green)
                )
            }
        }
    }
}