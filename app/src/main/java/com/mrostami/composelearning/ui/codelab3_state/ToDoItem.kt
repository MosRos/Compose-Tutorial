package com.mrostami.composelearning.ui.codelab3_state

data class ToDoItem(
    val title: String,
    val position: Int,
    val status: ToDoStatus = ToDoStatus.TODO,
    val priority: ToDoPriority = ToDoPriority.NORMAL
)

enum class ToDoStatus() {
    TODO,
    DOING,
    DONE,
    DELETED,
}

enum class ToDoPriority {
    LOW,
    NORMAL,
    IMPORTANT,
    URGENT
}
