package com.example.todosapp.ui.viewModels

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel

class TodosListViewModel(application: Application) : AndroidViewModel(application) {
    val todos = mutableStateListOf<String>()
}