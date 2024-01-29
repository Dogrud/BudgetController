package com.example.budgetcontroller.pages

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.budgetcontroller.components.TableRow
import com.example.budgetcontroller.components.UnstyledTextField
import com.example.budgetcontroller.ui.theme.BackgroundElevated
import com.example.budgetcontroller.ui.theme.BudgetControllerTheme
import com.example.budgetcontroller.ui.theme.DividerColor
import com.example.budgetcontroller.ui.theme.Primary
import org.w3c.dom.Text


@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Add(navController: NavController){
        // TO DO: refactor this into a viewmodel because we re losing the
        // values when changing orientation
    val recurrences =
        listOf(
            "None",
            "Daily",
            "Weekly",
            "Monthly",
            "Yearly"
        )
    val categories =
        listOf(
            "Groceries",
            "Bills",
            "Hobbies",
            "Take out"
        )

    val selectedRecurrence = remember {
            mutableStateOf(recurrences[0])
        }
    val selectedCategory = remember {
        mutableStateOf(categories[0])
    }


        Scaffold(
            topBar = {
                MediumTopAppBar(title = { Text(text = "Add") })
            },
            content = {innerPadding ->
                Column (modifier = Modifier.padding(innerPadding), horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Column (modifier = Modifier
                        .padding(16.dp)
                        .background(BackgroundElevated)
                        .fillMaxWidth()
                    ){
                        TableRow(label = "Amount" ){
                            UnstyledTextField(
                                value = "hello",
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                textStyle = TextStyle(
                                    textAlign = TextAlign.End
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                )
                                )
                        }
                        Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Recurrence", ){
                            val recurrenceMenuOpened = remember{
                                mutableStateOf(false)
                            }
                            TextButton(onClick = { recurrenceMenuOpened.value = true}) {
                                Text(selectedRecurrence.value)
                                DropdownMenu(expanded = recurrenceMenuOpened.value, onDismissRequest = { recurrenceMenuOpened.value = false }) {
                                    recurrences.forEach{
                                        recurrence ->
                                        DropdownMenuItem(
                                            text = { Text(text = recurrence) },
                                            onClick = {
                                                selectedRecurrence.value = recurrence
                                                recurrenceMenuOpened.value = false
    
                                            }
                                        )
                                    }

                                }
                            }

                        }
                        Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Date",)
                        Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Note",){
                            UnstyledTextField(
                                value = "",
                                onValueChange = {},
                                modifier = Modifier.fillMaxWidth(),
                                textStyle = TextStyle(
                                    textAlign = TextAlign.Right
                                ),
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Number,
                                )
                            )
                        }
                        Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                        TableRow(label = "Category"){
                            val categoryMenuOpened = remember{
                                mutableStateOf(false)
                            }
                            TextButton(onClick = { categoryMenuOpened.value = true}) {
                                Text(selectedCategory.value)
                                DropdownMenu(expanded = categoryMenuOpened.value, onDismissRequest = { categoryMenuOpened.value = false }) {
                                    categories.forEach{
                                            category ->
                                        DropdownMenuItem(
                                            text = {
                                                Row (verticalAlignment = Alignment.CenterVertically){
                                                    Surface (modifier = Modifier.size(10.dp), shape = CircleShape,color = Primary){

                                                    }
                                                    Text(text = category)
                                                }
                                                   },
                                            onClick = {
                                                selectedCategory.value = category
                                                categoryMenuOpened.value = false

                                            }
                                        )
                                    }

                                }
                            }
                    }

                }
                    Button(
                        onClick = { },
                    )  {
                        Text("Submit Expense")

                    }

                }


            }

        )


    }
