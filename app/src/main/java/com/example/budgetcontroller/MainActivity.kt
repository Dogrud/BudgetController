package com.example.budgetcontroller

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.budgetcontroller.pages.Add
import com.example.budgetcontroller.pages.Categories
import com.example.budgetcontroller.pages.Expenses
import com.example.budgetcontroller.pages.Reports
import com.example.budgetcontroller.pages.Settings
import com.example.budgetcontroller.ui.theme.BudgetControllerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            BudgetControllerTheme {
                // A surface container using the 'background' color from the theme
                val navController = rememberNavController()
                val backStackEntry = navController.currentBackStackEntryAsState()
                var showBottomBar by rememberSaveable {
                    mutableStateOf(true)
                }

                showBottomBar = when(backStackEntry.value?.destination?.route){
                    "settings/categories" -> false
                    else -> true

                }
                
              Scaffold (
                  content = {innerPadding ->
                                NavHost(navController = navController, startDestination = "expenses"){
                                    composable("expenses"){
                                        Surface (modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding)){
                                            Expenses(navController)
                                        }
                                    }
                                    composable("reports"){
                                        Surface (modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding)){
                                            Reports(navController)
                                        }
                                    }
                                    composable("add"){
                                        Surface (modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding)){
                                            Add(navController)
                                        }
                                    }
                                    composable("settings"){
                                        Surface (modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding)){
                                            Settings(navController)
                                        }
                                    }
                                    composable("settings/categories"){
                                        Surface (modifier = Modifier
                                            .fillMaxSize()
                                            .padding(innerPadding)){
                                            Categories(navController)
                                        }
                                    }
                                }
                  },
                  bottomBar ={if(showBottomBar){
                      NavigationBar {
                          NavigationBarItem(
                              selected = backStackEntry.value?.destination?.route == "expenses",
                              onClick = { navController.navigate("expenses") },
                              label = { Text(text = "Expenses")},
                              icon = { Icon(painterResource(id = R.drawable.baseline_upload_24),contentDescription = "Upload")})
                          NavigationBarItem(
                              selected = backStackEntry.value?.destination?.route == "reports",
                              onClick = { navController.navigate("reports") },
                              label = { Text(text = "Reports")},
                              icon = { Icon(painterResource(id = R.drawable.baseline_bar_chart_24),contentDescription = "Reports")})
                          NavigationBarItem(
                              selected = backStackEntry.value?.destination?.route == "add",
                              onClick = { navController.navigate("add") },
                              label = { Text(text = "Add")},
                              icon = { Icon(painterResource(id = R.drawable.outline_add_24),contentDescription = "Add")})
                          NavigationBarItem(
                              selected = backStackEntry.value?.destination?.route?.startsWith("settings") ?: false,
                              onClick = { navController.navigate("settings") },
                              label = { Text(text = "Settings")},
                              icon = { Icon(painterResource(id = R.drawable.baseline_settings_24),contentDescription = "Settings")})
                      }

                  }} ,

              )
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.White,
        modifier = Modifier
            .background(Color.Black)
    )
}
