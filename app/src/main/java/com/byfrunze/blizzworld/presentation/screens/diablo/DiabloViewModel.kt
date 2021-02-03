package com.byfrunze.blizzworld.presentation.screens.diablo

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.byfrunze.blizzworld.data.repository.RemoteRepository
import com.byfrunze.blizzworld.presentation.base.BaseViewModel
import com.byfrunze.blizzworld.presentation.screens.diablo.models.DiabloAction
import com.byfrunze.blizzworld.presentation.screens.diablo.models.DiabloEvent
import com.byfrunze.blizzworld.presentation.screens.diablo.models.DiabloViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DiabloViewModel @ViewModelInject constructor(
    val remoteRepository: RemoteRepository
) : BaseViewModel<DiabloViewState, DiabloAction, DiabloEvent>() {
    override fun obtainEvent(viewEvent: DiabloEvent) {
        when (viewEvent) {
            is DiabloEvent.GetToken -> getToken()
        }
    }

    private fun getToken() {
        viewModelScope.launch(Dispatchers.IO) {
            remoteRepository.getToken().collect {
                Log.i("TOKEN1", "${it.access_token}")
            }
        }
    }
}