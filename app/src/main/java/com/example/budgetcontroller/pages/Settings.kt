package com.example.budgetcontroller.pages

import android.provider.Settings
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.budgetcontroller.components.TableRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController){
    Scaffold(

        content = {innerPadding ->
            Column (modifier = Modifier.padding(innerPadding))
            {
                TableRow(label = "Categories", hasArrow = true)
                TableRow(label = "Erase all data", isDestructive = true)
            }
        },
        topBar = {
            MediumTopAppBar(title = { Text(text = "Settings") })
        }

    )


}