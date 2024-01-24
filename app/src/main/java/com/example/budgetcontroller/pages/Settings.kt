package com.example.budgetcontroller.pages

import android.provider.Settings
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.budgetcontroller.components.TableRow
import com.example.budgetcontroller.ui.theme.BackgroundElevated
import com.example.budgetcontroller.ui.theme.DividerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Settings(navController: NavController){
    Scaffold(

        content = {innerPadding ->
            Column (modifier = Modifier.padding(innerPadding))
            {
                Column (modifier = Modifier
                    .padding(16.dp)
                    .background(BackgroundElevated)
                    .fillMaxWidth()
                ){
                    TableRow(label = "Categories", hasArrow = true)
                    Divider(modifier = Modifier.padding(start = 16.dp), thickness = 1.dp, color = DividerColor)
                    TableRow(label = "Erase all data", isDestructive = true)
                }

            }
        },
        topBar = {
            MediumTopAppBar(title = { Text(text = "Settings") })
        }

    )


}