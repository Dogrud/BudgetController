package com.example.budgetcontroller.viewModels

import androidx.lifecycle.ViewModel
import com.example.budgetcontroller.models.Recurrence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class ExpensesState(
val recurrence: Recurrence = Recurrence.Daily,
val sumTotal: Double = 1250.98

)

class ExpensesViewModel: ViewModel() {

    private val _uistate = MutableStateFlow(ExpensesState())
    val uiState: StateFlow<ExpensesState> = _uistate.asStateFlow()

fun setRecurrence(recurrence: Recurrence){

    _uistate.update { currentState ->
        currentState.copy(
            recurrence = recurrence
        )
    }

}

}