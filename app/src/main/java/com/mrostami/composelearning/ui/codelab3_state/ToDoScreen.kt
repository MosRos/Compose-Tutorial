package com.mrostami.composelearning.ui.codelab3_state

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Save
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mrostami.composelearning.R
import com.mrostami.composelearning.ui.codelab4_theming.AppTheme
import com.mrostami.composelearning.ui.codelab4_theming.appColors
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class ToDoActivity : AppCompatActivity() {

    val viewModel: ToDoViewModel by viewModels<ToDoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme(darkMode = true) {
                androidx.compose.material.Surface(
                    color = MaterialTheme.appColors.background
                ) {
                    ToDoLayoutScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun ToDoLayoutScreen(viewModel: ToDoViewModel) {
    val items: List<ToDoItem> = viewModel.todoItems
    ToDoContentScreen(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp),
        items = items,
        addItem = { viewModel.addToDoItem(it) },
        removeItem = { viewModel.removeToDoItem(it) },
        updateItem = { viewModel.updateItem(it) }
    )
}

@Composable
fun ToDoContentScreen(
    modifier: Modifier = Modifier,
    items: List<ToDoItem>,
    addItem: (ToDoItem) -> Unit,
    removeItem: (ToDoItem) -> Unit,
    updateItem: (ToDoItem) -> Unit,
) {
    Column(
        modifier = modifier.padding(
            top = AppTheme.dimensions.marginMedium,
            start = AppTheme.dimensions.marginMedium,
            end = AppTheme.dimensions.marginMedium,
            bottom = 100.dp
        )
    ) {
        LazyColumn(state = rememberLazyListState()) {
            items(items) {
                items.sortedBy { it.position }.forEach {
                    ToDoItemView(toDo = it, removeItem = removeItem, updateItem = updateItem)
                }
            }
        }
        TodoAddItemView(onItemComplete = addItem)
    }
}

@Composable
fun ToDoItemView(
    toDo: ToDoItem,
    removeItem: (ToDoItem) -> Unit,
    updateItem: (ToDoItem) -> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = AppTheme.dimensions.marginMedium)
    ) {

        Checkbox(
            modifier = Modifier
                .padding(start = 4.dp)
                .align(alignment = Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.Start)
                .weight(1.0f),
            checked = toDo.status == ToDoStatus.DONE,
            onCheckedChange = {
                val updatedToDo = ToDoItem(
                    id = toDo.id,
                    title = toDo.title,
                    position = toDo.position,
                    status = ToDoStatus.DONE,
                    priority = toDo.priority
                )
                updateItem.invoke(updatedToDo)
            }
        )
        Spacer(modifier = Modifier.width(AppTheme.dimensions.paddingMedium))
        Text(
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .fillMaxWidth()
                .weight(1.0f),
            text = toDo.title,
            style = AppTheme.typography.title,
            color = MaterialTheme.appColors.textPrimary,
            textAlign = TextAlign.Start,
            maxLines = 1
        )

        Image(
            modifier = Modifier
                .padding(horizontal = AppTheme.dimensions.paddingSmall)
                .align(alignment = Alignment.CenterVertically)
                .wrapContentWidth(align = Alignment.End)
                .weight(1.0f)
                .clickable(enabled = true, onClick = {
                    isExpanded = !isExpanded
                }),
            imageVector = Icons.Default.MoreVert,
            colorFilter = ColorFilter.tint(color = MaterialTheme.appColors.textSecondary),
            contentDescription = "menu"
        )
        DropdownMenu(
            modifier = Modifier
                .wrapContentWidth(align = Alignment.End),

            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
        ) {
            DropdownMenuItem(onClick = { removeItem.invoke(toDo) }) {
                Text(
                    text = "Delete",
                    color = MaterialTheme.appColors.error,
                    style = AppTheme.typography.caption
                )
                Icon(imageVector = Icons.Rounded.Delete, contentDescription = "deleteIcon")
            }

            DropdownMenuItem(onClick = { removeItem.invoke(toDo) }) {
                Text(
                    text = "Delete",
                    color = MaterialTheme.appColors.error,
                    style = AppTheme.typography.caption
                )
                Icon(imageVector = Icons.Rounded.Delete, contentDescription = "deleteIcon")
            }

            DropdownMenuItem(
                onClick = {
                    val updatedToDo = ToDoItem(
                        id = toDo.id,
                        title = toDo.title,
                        position = toDo.position,
                        status = ToDoStatus.DOING,
                        priority = toDo.priority
                    )
                    updateItem.invoke(updatedToDo)
                }) {
                Text(
                    text = "Finish",
                    color = MaterialTheme.appColors.textSecondary,
                    style = AppTheme.typography.caption
                )
                Icon(imageVector = Icons.Rounded.Save, contentDescription = "saveIcon")
            }
        }
    }
}

@Composable
fun TodoAddItemView(onItemComplete: (ToDoItem) -> Unit) {
    val (text, setText) = remember { mutableStateOf("") }
    Column(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        TodoInputTextField(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            onTextChange = setText
        )
        TodoEditButton(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val todo = ToDoItem(
                    id = System.currentTimeMillis(),
                    title = text,
                    position = 0
                )
                onItemComplete.invoke(todo)
            },
            enabled = text.isNotEmpty(),
            text = "Add"
        )
    }
}

@Composable
fun TodoInputTextField(
    modifier: Modifier,
    text: String,
    onTextChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        value = text,
        onValueChange = onTextChange,
        textStyle = TextStyle(
            color = MaterialTheme.appColors.textPrimary,
            fontFamily = FontFamily(
                Font(R.font.raleway_medium, FontWeight.Medium)
            ),
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    )
}

// edit TodoItemInput
@Composable
fun TodoEditButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {
//        onItemComplete(TodoItem(text)) // send onItemComplete event up
//        setText("") // clear the internal text
    },
    text: String = "Add",
    enabled: Boolean = text.isNotBlank() // enable if text is not blank
) {
    Button(
        onClick = onClick,
        shape = AppTheme.shapes.small,
        enabled = enabled,
        modifier = modifier.padding(horizontal = 10.dp, vertical = 5.dp)
    ) {
        Text(
            text = text,
            style = AppTheme.typography.button,
            textAlign = TextAlign.Center
        )
    }
}