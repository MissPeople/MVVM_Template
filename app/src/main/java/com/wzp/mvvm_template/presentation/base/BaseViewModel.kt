package com.wzp.mvvm_template.presentation.base

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * For simplicity we declare this base interfaces here.
 * So that we can remove BaseViewModel easily in case we want to move away from this architecture.
 */
interface UiEffect
interface UiEvent

/**
 * Currently the Base interface for UiState is not used (but we added the implementation in case we want to remove
 * some Boilerplate from ViewModel in future with BaseViewModel<UiEvent,UiState,UiEffect>)
 */
interface UiState

/**
 * We could Generify BaseViewModel to be BaseViewModel<State,Event,Effect> but it would add some unwanted complexity.
 * Class extending BaseViewModel shouldn't know its implementation details as much as possible.
 *
 * For this reason we will only keep Event and Effect in the Base class.
 * Because UIState needs to be initialized. It must be done by the Class extending BaseViewModel.
 *
 * Note:
 * We are using Flow, we could easily use LiveData instead but Flows are simpler to test.
 */
abstract class BaseViewModel : ViewModel() {
    // Shared flow to listen to Event (Clicks/Actions from users)
    private val _event: MutableSharedFlow<UiEvent> = MutableSharedFlow()

    @VisibleForTesting
    val event = _event.asSharedFlow()

    // Channel Flow to channel Effect from ViewModel to the View (Channel because we force the action to happen)
    private val _effect: Channel<UiEffect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeToEvents()
    }

    private fun subscribeToEvents() {
        viewModelScope.launch {
            event.collect {
                handleEvent(it)
            }
        }
    }

    // Called from the View to notify the ViewModel that a UIEvent occurred
    fun notifyEvent(event: UiEvent) {
        val newEvent = event
        viewModelScope.launch { _event.emit(newEvent) }
    }

    // Call from the ViewModel to notify the View that an Effect must be triggered
    fun triggerEffect(builder: () -> UiEffect) {
        val effectToTrigger = builder()
        viewModelScope.launch { _effect.send(effectToTrigger) }
    }

    // We don't want to View to access internal specific ViewModel implementation directly. So for events, it must be passed through Flow/Livedata
    abstract fun handleEvent(event: UiEvent)
}