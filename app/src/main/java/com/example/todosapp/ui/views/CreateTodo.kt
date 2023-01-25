package com.example.todosapp.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todosapp.ui.viewModels.CreateTodoViewModel
import kotlinx.coroutines.launch

@Composable
fun CreateTodo(navController: NavController) {
    val viewModel: CreateTodoViewModel = viewModel()
    val scope = rememberCoroutineScope()
    //add button to save the todo
    //add route to this page
    Column() {
        TextField(value = viewModel.name, onValueChange = { viewModel.name = it })
        TextField(value = viewModel.description, onValueChange = {viewModel.description = it})
    }
}