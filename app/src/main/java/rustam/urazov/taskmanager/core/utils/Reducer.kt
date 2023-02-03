package rustam.urazov.taskmanager.core.platform

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class Reducer<S : UiState, E: UiEvent>(initialValue: S) {

    private val mutableState: MutableStateFlow<S> = MutableStateFlow(initialValue)
    val state: StateFlow<S> = mutableState.asStateFlow()

    fun sendEvent(event: E) {
        reduce(mutableState.value, event)
    }

    fun setState(state: S) {
        mutableState.tryEmit(state)
    }

    abstract fun reduce(oldState: S, event: E)

}