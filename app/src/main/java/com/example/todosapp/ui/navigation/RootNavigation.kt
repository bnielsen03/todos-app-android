package com.example.todosapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.example.todosapp.ui.views.CreateTodo
import com.example.todosapp.ui.views.TodosList
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RootNavigation() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar {
                IconButton(onClick = { scope.launch { scaffoldState.drawerState.open() } }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu Button")
                }

                Text(text = "Tire Guru Todos App")
            }
        },
        floatingActionButton = {
            if (currentDestination?.route == Routes.todosList.route) {
                FloatingActionButton(onClick = { navController.navigate(Routes.createTodo.route) }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Create Todo")
                }
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
                composable(route = Routes.createTodo.route) {
                    CreateTodo(navController = navController)
                }
            }
        }
    }

}