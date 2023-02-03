package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
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