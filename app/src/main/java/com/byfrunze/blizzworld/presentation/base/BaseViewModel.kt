package com.byfrunze.blizzworld.presentation.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<S, A, E> : ViewModel() {

    private val TAG = BaseViewModel::class.java.simpleName
    private val _viewStates: MutableStateFlow<S?> = MutableStateFlow(null)
    fun viewStates(): StateFlow<S?> = _viewStates

    private var _viewState: S? = null
    protected var viewState: S
        get() = _viewState
            ?: throw UninitializedPropertyAccessException("\"viewState\" was queried before being initialized")
        set(value) {
            _viewState = value
            _viewStates.value = value
        }


    private val _viewActions: MutableStateFlow<A?> = MutableStateFlow(null)
    fun viewAction(): StateFlow<A?> = _viewActions

    private var _viewAction: A? = null
    protected var viewAction: A
        get() = _viewAction
            ?: throw UninitializedPropertyAccessException("\"viewAction\" was queried before being initialized")
        set(value) {
            _viewAction = value
            _viewActions.value = value
        }

    abstract fun obtainEvent(viewEvent: E)
}