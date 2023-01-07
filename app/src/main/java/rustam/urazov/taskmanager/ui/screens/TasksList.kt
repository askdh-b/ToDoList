package rustam.urazov.taskmanager.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import rustam.urazov.taskmanager.ui.theme.LargeMediumPaddings
import rustam.urazov.taskmanager.ui.theme.NoneMediumPaddings
import rustam.urazov.taskmanager.ui.theme.TaskManagerTheme

@Composable
fun TasksList(tasks: List<TaskView>) {
    val tasksLazyListState = rememberLazyListState()

    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        state = tasksLazyListState,
        contentPadding = NoneMediumPaddings
    ) {
        items(tasks) { task ->
            Task(task = task, modifier = Modifier.padding(LargeMediumPaddings))
        }
    }
}

@Preview
@Composable
fun TasksListPreview() {
    TaskManagerTheme {
        Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFEEDDEE)) {
            Column {
                val tasks = mutableListOf<TaskView>()
                repeat(10) { tasks.add(TaskView("asd", "asd", "asd")) }
                TasksList(tasks = tasks)
            }
        }
    }
}