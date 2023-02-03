package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rustam.urazov.taskmanager.R
import rustam.urazov.taskmanager.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskBackground(dismissState: DismissState, threshold: Float) {
    val dismissFraction = dismissState.progress.fraction
    val offset by remember { mutableStateOf(dismissState.offset) }
    val density = LocalDensity.current

    val deleteAction = Action(ActionState(Red, White))
    var deleteActionState by remember { mutableStateOf(deleteAction.cancelled) }

    val doneAction = Action(ActionState(Green, White))
    var doneActionState by remember { mutableStateOf(doneAction.cancelled) }

    deleteActionState = when(dismissFraction < threshold) {
        true -> deleteAction.cancelled
        false -> deleteAction.dismissed
    }

    doneActionState = when (dismissFraction < threshold) {
        true -> doneAction.cancelled
        false -> doneAction.dismissed
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        val boxSize = 32.dp
        val currentOffset = density.run { offset.value.toDp() / 2 }

        ActionIcon(
            boxSize = boxSize,
            offset = currentOffset - boxSize,
            actionState = doneActionState,
            icon = painterResource(id = R.drawable.ic_done_24_green)
        )

        ActionIcon(
            boxSize = boxSize,
            offset = maxWidth + currentOffset,
            actionState = deleteActionState,
            icon = painterResource(id = R.drawable.ic_delete_24_red)
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun TaskBackgroundPreview() {
    TaskManagerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFEEDDEE)) {
            Column(modifier = Modifier.fillMaxSize()) {
                val threshold = .4f
                val dismissState = rememberDismissState()

                SwipeToDismiss(
                    state = dismissState,
                    dismissThresholds = { FractionalThreshold(threshold) },
                    background = { TaskBackground(dismissState, threshold) },
                    dismissContent = {
                        Column(modifier = Modifier.fillMaxSize().background(White)) {

                        }
                    }
                )
            }
        }
    }
}