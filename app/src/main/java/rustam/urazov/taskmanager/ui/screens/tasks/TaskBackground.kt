package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import rustam.urazov.taskmanager.R
import rustam.urazov.taskmanager.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TaskBackground(dismissState: DismissState, threshold: Float) {
    val dismissFraction = dismissState.progress.fraction
    val offset by remember { mutableStateOf(dismissState.offset) }
    val density = LocalDensity.current
    var deleteIconBackgroundColor by remember { mutableStateOf(Transparent) }
    var deleteIconColor by remember { mutableStateOf(Transparent) }
    var doneIconBackgroundColor by remember { mutableStateOf(Transparent) }
    var doneIconColor by remember { mutableStateOf(Transparent) }

    deleteIconBackgroundColor = when (dismissFraction < threshold) {
        true -> White
        false -> Red
    }

    deleteIconColor = when (dismissFraction < threshold) {
        true -> Red
        false -> White
    }

    doneIconBackgroundColor = when (dismissFraction < threshold) {
        true -> White
        false -> Green
    }

    doneIconColor = when (dismissFraction < threshold) {
        true -> Green
        false -> White
    }

    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.CenterStart
    ) {
        val boxSize = 32.dp
        val currentOffset = maxWidth + density.run { offset.value.toDp() / 2 }

        ActionIcon(
            boxSize = boxSize,
            offset = currentOffset - maxWidth - boxSize,
            backgroundColor = doneIconBackgroundColor,
            iconColor = doneIconColor,
            icon = painterResource(id = R.drawable.ic_done_24_green)
        )

        ActionIcon(
            boxSize = boxSize,
            offset = currentOffset,
            backgroundColor = deleteIconBackgroundColor,
            iconColor = deleteIconColor,
            icon = painterResource(id = R.drawable.ic_delete_24_red)
        )
    }
}

@Composable
fun ActionIcon(
    boxSize: Dp,
    offset: Dp,
    backgroundColor: Color,
    iconColor: Color,
    icon: Painter
) {
    Box(
        modifier = Modifier
            .size(boxSize)
            .offset(x = offset)
            .clip(Shapes.large)
            .background(backgroundColor)
    ) {
        Icon(
            modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
            painter = icon,
            contentDescription = null,
            tint = iconColor
        )
    }
}