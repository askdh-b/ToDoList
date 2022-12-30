package rustam.urazov.taskmanager.ui.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import rustam.urazov.taskmanager.ui.theme.Typography

@Composable
fun HeaderText(text: String) {
    Text(text = text, color = Color.Black, style = Typography.h1)
}