package com.mrostami.composelearning.ui.codelab3_state

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoViewModel @Inject constructor() : ViewModel(){

    val toDoItemsState: MutableStateFlow<List<ToDoItem>> = MutableStateFlow(listOf())

    fun addToDoItem(item: ToDoItem) {
        val items: ArrayList<ToDoItem> = ArrayList(toDoItemsState.value.distinctBy { it.position })
        items.add(item)
        viewModelScope.launch {
            toDoItemsState.emit(items)
        }
    }

    fun removeToDoItem(item: ToDoItem) {
        val items: ArrayList<ToDoItem> = ArrayList(toDoItemsState.value.distinctBy { it.position })
        items.remove(item)
        viewModelScope.launch {
            toDoItemsState.emit(items)
        }
    }

    fun updateItem(item: ToDoItem) {
        val items: MutableList<ToDoItem> = toDoItemsState.value.distinctBy { it.position }.toMutableList()
        val j = items.indexOf(item)
        if (j < items.size) {
            items.removeAt(j)
            items.add(index = j, item)
        }
        viewModelScope.launch {
            toDoItemsState.emit(items.toList())
        }
    }

}