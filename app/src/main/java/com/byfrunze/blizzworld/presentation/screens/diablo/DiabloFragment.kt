package com.byfrunze.blizzworld.presentation.screens.diablo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.byfrunze.blizzworld.R
import com.byfrunze.blizzworld.presentation.screens.diablo.models.DiabloAction
import com.byfrunze.blizzworld.presentation.screens.diablo.models.DiabloEvent
import com.byfrunze.blizzworld.presentation.screens.diablo.models.DiabloViewState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class DiabloFragment : Fragment(R.layout.fragment_diablo) {


    private val viewModel: DiabloViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launchWhenStarted {
            viewModel.viewAction().collect { action -> action?.let { bindViewAction(action) } }
            viewModel.viewStates().collect { state -> state?.let { bindViewState(state) } }
        }
        viewModel.obtainEvent(DiabloEvent.GetToken)
    }

    private fun bindViewState(viewState: DiabloViewState) {

    }

    private fun bindViewAction(viewAction: DiabloAction) {

    }
}