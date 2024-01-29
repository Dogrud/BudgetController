package com.example.budgetcontroller.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.budgetcontroller.components.TableRow
import com.example.budgetcontroller.components.UnstyledTextField
import com.example.budgetcontroller.ui.theme.BackgroundElevated
import com.example.budgetcontroller.ui.theme.DividerColor
import com.example.budgetcontroller.ui.theme.Primary
import org.w3c.dom.Text


@OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Add(navController: NavController){
        Scaffold(

            content = {innerPadding ->
                Column (modifier = Modifier.padding(innerPadding))
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
                        TableRow(label = "Recurrence", )
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
                        TableRow(label = "Category")
                    }

                }
            },
            topBar = {
                MediumTopAppBar(title = { Text(text = "Add") })
            }

        )


    }
