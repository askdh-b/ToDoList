package rustam.urazov.taskmanager.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rustam.urazov.taskmanager.ui.screens.TasksScreen

@Composable
fun TaskManagerNavGraph() {
    NavHost(navController = rememberNavController(), startDestination = TaskManagerDestinations.TASKS_ROUTE) {
        composable(route = TaskManagerDestinations.TASKS_ROUTE) {
            TasksScreen({})
        }
    }
}