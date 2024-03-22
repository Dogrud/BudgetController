package com.example.budgetcontroller.viewModels

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.budgetcontroller.models.Recurrence
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate

data class AddScreenState(
    val amount: String = "",
    val recurrence: Recurrence? = null,
    val date: LocalDate = LocalDate.now(),
    val note: String = "",
    val category: String? = null// TODO: Replace When you build the Category Model

)

class AddViewModel: ViewModel(){

    private val _uistate = MutableStateFlow(AddScreenState())

    val uiState: StateFlow<AddScreenState> = _uistate.asStateFlow()


    fun setAmount(amount: String){
        _uistate.update { currentState ->
            currentState.copy(
                amount = amount,
            )
        }

    }

    fun setRecurrence( recurrence: Recurrence){
        _uistate.update { currentState ->
            currentState.copy(
                recurrence = recurrence,
            )
        }

    }

    fun setDate(date: LocalDate){
        _uistate.update { currentState ->
            currentState.copy(
                date = date,
            )
        }

    }

    fun setNote(note: String){
        _uistate.update { currentState ->
            currentState.copy(
                note = note,
            )
        }

    }

    fun setCategory( category: String){ // TODO replace string with actual category class
        _uistate.update { currentState ->
            currentState.copy(
                category = category,
            )
        }

    }

    fun submitExpense(){
        // TODO save to local DB
    }


}