package com.mrostami.composelearning.ui.codelab3_state

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor() : ViewModel() {

    // state: todoItems
    var todoItems = mutableStateListOf<ToDoItem>()
        private set

    fun addToDoItem(item: ToDoItem) {
        todoItems.add(item)
    }

    fun removeToDoItem(item: ToDoItem) {
        todoItems.remove(item)
    }

    fun updateItem(item: ToDoItem) {
        if (todoItems.contains(item)) {
            val index = todoItems.indexOf(item)
            todoItems.removeAt(index)
            todoItems.add(index, item)
        }
    }
}