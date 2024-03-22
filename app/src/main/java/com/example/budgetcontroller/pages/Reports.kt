package com.example.budgetcontroller.pages

import MonthlyChart
import WeeklyChart
import YearlyChart
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.budgetcontroller.R
import com.example.budgetcontroller.components.PickerTrigger
import com.example.budgetcontroller.components.expensesList.ExpensesList
import com.example.budgetcontroller.models.Recurrence
import com.example.budgetcontroller.models.recurrence
import com.example.budgetcontroller.ui.theme.LabelSecondary
import com.example.budgetcontroller.ui.theme.Typography
import com.example.budgetcontroller.viewModels.ReportsViewModel
import com.nikolovlazar.goodbyemoney.mock.mockExpenses
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Reports(navController: NavController,vm: ReportsViewModel = viewModel()) {
    val uiState by vm.uiState.collectAsState()

    val recurrences =
        listOf(
            Recurrence.Weekly,
            Recurrence.Monthly,
            Recurrence.Yearly
        )
    Scaffold(
        topBar = {
            MediumTopAppBar(
                title = { Text(text = "Reports") },
                actions = { IconButton(
                    onClick =vm::openRecurrenceMenu
                ) {
                    Icon(painter = painterResource(id = R.drawable.baseline_edit_calendar_24), contentDescription = "select recurrence of chart")
                }
                DropdownMenu(expanded = uiState.recurrenceMnuOpened, onDismissRequest =  vm::closeRecurrenceMenu) {
                    recurrences.forEach{
                        recurrence: Recurrence ->
                        DropdownMenuItem(
                            text = { Text(text = recurrence.name)},
                            onClick = {
                                vm.setRecurrence(recurrence)
                                vm.closeRecurrenceMenu()
                            })


                    }
                }
                
                }
            )

        },

        content = {innerPadding ->
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
                    .fillMaxWidth()
            )
            {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ){
                    Column {
                        Text(text = "12 Sep = 18 Sep")
                        Row (modifier = Modifier.padding(top = 4.dp)){
                            Text(text =  "USD",
                                style = Typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp)
                                )
                            Text(text =  "85", style = Typography.headlineMedium)
                        }
                    }
                    Column (horizontalAlignment = Alignment.End){
                        Text(text = "Avg/day")
                        Row (modifier = Modifier.padding(top = 4.dp)){
                            Text(text =  "USD",
                                style = Typography.bodyMedium,
                                color = LabelSecondary,
                                modifier = Modifier.padding(end = 4.dp))
                            Text(text =  "85",style = Typography.headlineMedium)
                        }
                    }

                }

                when(uiState.recurrence)
                {
                    Recurrence.Weekly -> WeeklyChart(expenses = mockExpenses)
                    Recurrence.Monthly -> MonthlyChart(expenses = mockExpenses, month = LocalDate.now() )
                    Recurrence.Yearly -> YearlyChart(expenses = mockExpenses)
                    else -> Unit
                }

             
                ExpensesList(expenses = mockExpenses, modifier = Modifier
                    .weight(1f)
                    .verticalScroll(
                        rememberScrollState()
                    ) )

            }
        },


        )


}