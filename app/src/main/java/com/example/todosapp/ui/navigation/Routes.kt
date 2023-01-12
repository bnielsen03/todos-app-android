package com.example.todosapp.ui.navigation

data class Screen(val route: String)

object Routes {
    val sheetNavigation = Screen("sheetnavigation")
    val todosList = Screen("todosList")
}