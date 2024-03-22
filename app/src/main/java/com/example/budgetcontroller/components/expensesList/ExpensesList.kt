package com.example.budgetcontroller.components.expensesList

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgetcontroller.components.ExpensesDayGroup
import com.example.budgetcontroller.models.Expense
import com.example.budgetcontroller.models.groupedByDay
import com.example.budgetcontroller.ui.theme.BudgetControllerTheme
import com.nikolovlazar.goodbyemoney.mock.mockExpenses


@Composable
fun ExpensesList(expenses: List<Expense>,modifier: Modifier){

    val groupedExpenses = expenses.groupedByDay()

    Column(modifier = modifier){
        groupedExpenses.keys.forEach{ date ->
            if(groupedExpenses[date] != null){
                ExpensesDayGroup(date,groupedExpenses[date]!!,modifier = Modifier.padding(top = 24.dp))
            }
        }




    }






}


@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun Preview(){
    BudgetControllerTheme {
        ExpensesList(expenses = mockExpenses,modifier = Modifier)
    }
}