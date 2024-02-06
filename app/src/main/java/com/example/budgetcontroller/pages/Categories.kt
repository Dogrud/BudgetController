package com.example.budgetcontroller.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.budgetcontroller.Greeting
import com.example.budgetcontroller.components.TableRow
import com.example.budgetcontroller.ui.theme.BackgroundElevated
import com.example.budgetcontroller.ui.theme.DividerColor
import com.example.budgetcontroller.ui.theme.TopAppBarBackground


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Categories (navController : NavController){
    Scaffold(
        topBar = {
            MediumTopAppBar(title = { Text(text = "Categories") },
                navigationIcon = {


                    Surface(
                        onClick = navController::popBackStack,
                        color = Color.Transparent

                    ){
                        Row(modifier = Modifier.padding(vertical = 10.dp)){
                            Icon(
                                Icons.Rounded.KeyboardArrowLeft,
                                contentDescription = "Settings"
                            )
                            Text(text = "Settings")
                        }
                    }


                }
            )
            
                 },
        
        content = {innerPadding ->
            Column (modifier = Modifier.padding(innerPadding))
            {
                Column (modifier = Modifier
                    .padding(16.dp)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
                ){
                    TableRow(label = "Groceries")
                    Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Bills",)
                    Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Take Out",)
                    Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Subscriptions")
                }

            }
        }
       

    )

}