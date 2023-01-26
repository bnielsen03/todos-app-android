package com.example.todosapp.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.todosapp.ui.viewModels.CreateTodoViewModel
import kotlinx.coroutines.launch

@Composable
fun CreateTodo(navController: NavController) {
    val viewModel: CreateTodoViewModel = viewModel()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        androidx.compose.material.Surface(elevation = 4.dp) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {

                Text(text = "Edit Todo")

                OutlinedTextField(
                    value = viewModel.name,
                    placeholder = { Text(text = "Name") },
                    onValueChange = { viewModel.name = it })

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    value = viewModel.description,
                    placeholder = { Text(text = "Description") },
                    onValueChange = { viewModel.description = it })

                Spacer(modifier = Modifier.height(4.dp))

                Box {
                    OutlinedTextField(
                        value = viewModel.category,
                        modifier = Modifier
                            .padding(0.dp, 4.dp)
                            .clickable {
                                viewModel.dropDown = true
                            },
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Default.ArrowDropDown,
                                contentDescription = "Category Dropdown"
                            )
                        },
                        enabled = false,
                        label = { Text(text = "Category") },
                        onValueChange = {}
                    )

                    DropdownMenu(expanded = viewModel.dropDown, onDismissRequest = { viewModel.dropDown = false }) {
                        listOf(
                            "Work",
                            "Personal"
                        ).forEach {
                            DropdownMenuItem(onClick = { viewModel.category = it }) {
                                Text(text = it)
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(4.dp))

                Button(onClick = {
                    scope.launch { viewModel.createTodo() }
                }) {
                    Text(text = "Save")
                }

            }
        }
    }
}
