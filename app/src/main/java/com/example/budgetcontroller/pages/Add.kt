package com.example.budgetcontroller.pages

import android.app.DatePickerDialog
import android.content.res.Configuration
import android.os.Build
import android.text.format.DateFormat
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults.indicatorLine
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgetcontroller.components.TableRow
import com.example.budgetcontroller.components.UnstyledTextField
import com.example.budgetcontroller.models.Recurrence
import com.example.budgetcontroller.ui.theme.BackgroundElevated
import com.example.budgetcontroller.ui.theme.BudgetControllerTheme
import com.example.budgetcontroller.ui.theme.DividerColor
import com.example.budgetcontroller.ui.theme.Primary
import com.example.budgetcontroller.viewModels.AddViewModel
import org.w3c.dom.Text
import java.time.Instant
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor
import java.util.Calendar


//!! fix the date and notes tablorows

@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Add(navController: NavController,vm: AddViewModel = viewModel()){
        // TO DO: refactor this into a viewmodel because we re losing the
        // values when changing orientation


        val state by vm.uiState.collectAsState()
    val recurrences =
        listOf(
            Recurrence.None,
            Recurrence.Daily,
            Recurrence.Weekly,
            Recurrence.Monthly,
            Recurrence.Yearly
        )
    val categories =
        listOf(
            "Groceries",
            "Bills",
            "Hobbies",
            "Take out"
        )


    val datePickerState = rememberDatePickerState(
        initialSelectedDateMillis = Instant.now().toEpochMilli()
    )
    val firstFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", java.util.Locale.ENGLISH)


    Scaffold(
            topBar = {
                MediumTopAppBar(title = { Text(text = "Add") })
            }

        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(BackgroundElevated)
                        .fillMaxWidth()
                ) {
                    TableRow(label = "Amount", detailContent = {
                        UnstyledTextField(
                            value =state.amount,
                            onValueChange = vm::setAmount,
                            arrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth(),
                            placeholder =  { Text("0") },
                            textStyle = TextStyle(
                                textAlign = TextAlign.End
                            ),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number,
                            )
                        )
                    })
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow(label = "Recurrence", detailContent = {
                        val recurrenceMenuOpened = remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = { recurrenceMenuOpened.value = true }) {
                            Text(state.recurrence?.name ?: Recurrence.None.name)
                            DropdownMenu(
                                expanded = recurrenceMenuOpened.value,
                                onDismissRequest = { recurrenceMenuOpened.value = false }) {
                                recurrences.forEach { recurrence ->
                                    DropdownMenuItem(
                                        text = { Text(recurrence.name) },
                                        onClick = {
                                            vm.setRecurrence(recurrence)
                                            recurrenceMenuOpened.value = false

                                        }
                                    )
                                }

                            }
                        }
                    })
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    var datePickerShowing by remember{
                        mutableStateOf(false)
                    }
                    TableRow(label = "Date", detailContent = {
                        TextButton(onClick = {datePickerShowing = true}) {
                            Text(text = state.date.toString())
                        }
                        if(datePickerShowing)
                        {
                            DatePickerDialog(
                                onDismissRequest = {datePickerShowing = false },
                                confirmButton = { Button(
                                    onClick = {
                                        // TODO add date picker selected value to the date state of the addviewmodel, convert the date millis
                                        val formattedDate= DateFormat.format("dd/MM/yyyy", datePickerState.selectedDateMillis ?: 82233213123).toString()
                                        val localDate = LocalDate.parse(formattedDate, firstFormatter)
                                        vm.setDate(localDate)
                                        datePickerShowing = false
                                    })
                                {
                                    Text("Select")
                                } },
                            ) {
                                DatePicker(  state = datePickerState,
                                    dateValidator = { timestamp ->
                                        timestamp < Instant.now().toEpochMilli()
                                    })
                            }
                        }
                    })
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow(label = "Note", detailContent = {
                        // TODO change the color of the text based on the selected category
                        UnstyledTextField(
                            value = state.note,
                            placeholder = { Text("Leave some notes") },
                            arrangement = Arrangement.End,
                            onValueChange = vm::setNote,
                            modifier = Modifier.fillMaxWidth(),
                            textStyle = TextStyle(
                                textAlign = TextAlign.Right,
                            ),

                            )
                    })
                    Divider(
                        modifier = Modifier.padding(start = 16.dp),
                        thickness = 1.dp,
                        color = DividerColor
                    )
                    TableRow(label = "Category", detailContent = {
                        val categoryMenuOpened = remember {
                            mutableStateOf(false)
                        }
                        TextButton(onClick = { categoryMenuOpened.value = true }) {
                            Text(state.category ?: "Select a category first")
                            DropdownMenu(
                                expanded = categoryMenuOpened.value,
                                onDismissRequest = { categoryMenuOpened.value = false }) {
                                categories.forEach { category ->
                                    DropdownMenuItem(
                                        text = {
                                            Row(verticalAlignment = Alignment.CenterVertically) {

                                                //TODO change the color based on the category

                                                Surface(
                                                    modifier = Modifier.size(10.dp),
                                                    shape = CircleShape,
                                                    color = Primary
                                                ) {

                                                }
                                                Text(text = category)
                                            }
                                        },
                                        onClick = {
                                            vm.setCategory(category)
                                            categoryMenuOpened.value = false

                                        }
                                    )
                                }

                            }
                        }
                    })

                }
                Button(
                    onClick = {vm::submitExpense},
                ) {
                    Text("Submit Expense")

                }

            }


        }


}





