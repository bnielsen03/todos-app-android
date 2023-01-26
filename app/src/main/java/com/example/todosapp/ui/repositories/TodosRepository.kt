package com.example.todosapp.ui.repositories

import com.example.todosapp.ui.models.CollectionPath
import com.example.todosapp.ui.models.Todo
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

object TodosRepository {
    private val todosCache = mutableListOf<Todo>()


    suspend fun create(todo: Todo): Todo {
        val doc = Firebase.firestore.collection(CollectionPath.COLLECTION_TODO.value).document()
        todo.id = doc.id
        doc.set(todo).await()
        return todo
    }
}