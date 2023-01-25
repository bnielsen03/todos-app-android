package com.example.todosapp.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todosapp.ui.viewModels.TodosListViewModel

@Composable
fun TodosList(navController: NavController) {
    val viewModel: TodosListViewModel = viewModel()
    
    Column(modifier = Modifier
        .fillMaxSize()
        .padding()
        .verticalScroll(rememberScrollState())
    ) {
        Text(text = "We are in the todos list")
    }
    
}