package com.example.budgetcontroller.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.budgetcontroller.models.DayExpenses
import com.example.budgetcontroller.models.Expense
import com.example.budgetcontroller.ui.theme.LabelSecondary
import com.example.budgetcontroller.ui.theme.Typography
import com.nikolovlazar.goodbyemoney.utils.formatDay
import java.text.DecimalFormat
import java.time.LocalDate

@Composable
fun ExpensesDayGroup (date: LocalDate, dayExpenses: DayExpenses,modifier: Modifier = Modifier){

    Column (modifier = modifier){
        Text(
            date.formatDay(),
            style = Typography.headlineMedium,
            color = LabelSecondary)
        Divider(modifier = Modifier.padding(top = 10.dp, bottom = 4.dp))

        dayExpenses.expenses.forEach {expense -> ExpenseRow(

            expense = expense,
            modifier = Modifier.padding(top = 12.dp)
        )

        }

        Divider(modifier = Modifier.padding(top = 16.dp, bottom = 4.dp))

        Row (modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween){
            Text("Total:", style = Typography.bodyMedium, color = LabelSecondary)
            Text(
                text = DecimalFormat("USD 0.#").format(dayExpenses.total),
                style = Typography.headlineMedium ,
                color = LabelSecondary)
        }
    }
}