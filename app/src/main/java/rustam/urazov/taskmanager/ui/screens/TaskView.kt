package rustam.urazov.taskmanager.ui.screens

data class TaskView(
    val name: String,
    val priority: Priority,
    val deadline: String,
    val description: String
)

enum class Priority {
    Low,
    Medium,
    High
}