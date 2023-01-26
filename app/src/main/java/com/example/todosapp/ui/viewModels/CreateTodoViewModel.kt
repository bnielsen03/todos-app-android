package com.example.todosapp.ui.viewModels

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import com.example.todosapp.ui.models.Todo
import com.example.todosapp.ui.repositories.TodosRepository

class CreateTodoViewModel(application: Application): AndroidViewModel(application) {
    var name by mutableStateOf("")
    var description by mutableStateOf("")
    var category by mutableStateOf("")

    var dropDown by mutableStateOf(false)

    //needs to be a suspend function
    suspend fun createTodo() {
        TodosRepository.create(
            Todo(
                name = name,
                description = description
            )
        )
    }
}