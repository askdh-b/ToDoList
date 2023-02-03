package rustam.urazov.taskmanager.ui.screens.tasks

import androidx.compose.ui.graphics.Color

class Action(actionState: ActionState) {
    val dismissed = ActionState(actionState.primaryColor, actionState.secondaryColor)
    val cancelled = ActionState(actionState.secondaryColor, actionState.primaryColor)
}

class ActionState(val primaryColor: Color, val secondaryColor: Color)