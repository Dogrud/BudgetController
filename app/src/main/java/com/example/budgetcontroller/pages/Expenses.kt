package com.example.budgetcontroller.pages

import android.content.res.Configuration
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.inputmethodservice.Keyboard
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgetcontroller.components.ExpensesDayGroup
import com.example.budgetcontroller.components.PickerTrigger
import com.example.budgetcontroller.components.expensesList.ExpensesList
import com.example.budgetcontroller.models.Recurrence
import com.example.budgetcontroller.ui.theme.BudgetControllerTheme
import com.example.budgetcontroller.ui.theme.LabelSecondary
import com.example.budgetcontroller.ui.theme.Typography
import com.example.budgetcontroller.viewModels.AddViewModel
import com.example.budgetcontroller.viewModels.ExpensesViewModel
import com.nikolovlazar.goodbyemoney.mock.mockExpenses

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Expenses(navController: NavController ,vm: ExpensesViewModel = viewModel())
{
    val recurrences =
        listOf(
            Recurrence.Daily,
            Recurrence.Weekly,
            Recurrence.Monthly,
            Recurrence.Yearly
        )

    val state by vm.uiState.collectAsState()
    var recurrenceMenuOpened by remember{
        mutableStateOf(false)
    }

    Scaffold(
        topBar = {
            MediumTopAppBar(title = { Text(text = "Expenses")})
        },

        content = {innerPadding ->
                  Column (
                      horizontalAlignment = Alignment.CenterHorizontally,
                      modifier = Modifier
                          .padding(innerPadding)
                          .padding(horizontal = 16.dp)
                          .fillMaxWidth()
                  )
                  {
                      Row (verticalAlignment = Alignment.CenterVertically){
                          Text(
                              text = "Total For:",
                              style = Typography.bodyMedium
                          )
                          PickerTrigger(state.recurrence.target ?: Recurrence.None.target, onClick = {
                                  recurrenceMenuOpened = !recurrenceMenuOpened
                              },
                                  modifier = Modifier.padding(start = 16.dp)
                              )
                          DropdownMenu(
                                  expanded = recurrenceMenuOpened,
                                  onDismissRequest = { recurrenceMenuOpened = false }) {
                                  recurrences.forEach { recurrence ->
                                      DropdownMenuItem(
                                          text = { Text(recurrence.target) },
                                          onClick = {
                                              vm.setRecurrence(recurrence)
                                              recurrenceMenuOpened = false

                                          }
                                      )
                                  }

                              }
                      }
                      Row (modifier = Modifier.padding(vertical = 32.dp)){
                          Text(text = "$", style = Typography.bodyMedium,
                              color = LabelSecondary,
                              modifier = Modifier.padding(end = 4.dp, top = 3.dp)
                              )
                          Text(text = "${state.sumTotal}", style = Typography.titleLarge)

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



@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ExpensesPreview() {
    BudgetControllerTheme{
        Expenses(navController = rememberNavController())
}

}