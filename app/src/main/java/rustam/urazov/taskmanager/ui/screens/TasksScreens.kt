package rustam.urazov.taskmanager.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.coroutineScope
import rustam.urazov.taskmanager.R
import rustam.urazov.taskmanager.ui.common.AddFloatingActionButton

@Composable
fun TasksScreen(
    onClick: () -> Unit
) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.tasks))
        }, actions = {

        })
    }, floatingActionButton = {
        AddFloatingActionButton(onClick = onClick)
    }) { innerPadding ->

    }
}