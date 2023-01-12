package com.example.todosapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.todosapp.ui.views.TodosList

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar {
                Text(text = "Tire Guru Todos App")
            }
        }
    ) {
        NavHost(navController = navController,
            startDestination = Routes.sheetNavigation.route,
            modifier = Modifier.padding(paddingValues = it)
            ) {
            navigation(route = Routes.sheetNavigation.route,
            startDestination = Routes.todosList.route
                ) {
                composable(route = Routes.todosList.route) {
                    TodosList(navController = navController)
                }
            }
        }
    }

}