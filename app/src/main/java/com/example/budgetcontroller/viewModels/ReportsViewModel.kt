package com.example.budgetcontroller.viewModels

import androidx.lifecycle.ViewModel
import com.example.budgetcontroller.models.Recurrence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class ReportsState(
    val recurrence: Recurrence = Recurrence.Weekly,
    val recurrenceMnuOpened: Boolean = false

)


class ReportsViewModel: ViewModel() {


    private val _uistate = MutableStateFlow(ReportsState())
    val uiState: StateFlow<ReportsState> = _uistate.asStateFlow()

    fun setRecurrence(recurrence: Recurrence){

        _uistate.update { currentState ->
            currentState.copy(
                recurrence = recurrence
            )
        }

    }

    fun openRecurrenceMenu(){
        _uistate.update { currentState ->
            currentState.copy(
                recurrenceMnuOpened = true
            )
        }
    }

    fun closeRecurrenceMenu(){
        _uistate.update { currentState ->
            currentState.copy(
                recurrenceMnuOpened = false
            )
        }
    }


}