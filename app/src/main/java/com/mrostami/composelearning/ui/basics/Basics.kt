package com.mrostami.composelearning.ui.basics

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mrostami.composelearning.R
import com.mrostami.composelearning.ui.theme.AppTheme

data class Message(val author: String, val body: String)


val mesgs = listOf(
    Message(author = "Steven", body = "Physics"),
    Message(author = "Albert", body = "Physics"),
    Message(author = "Bach", body = "Music"),
    Message(author = "Dali", body = "Art")
)

@Composable
fun ComposeBasicsApp() {
    AppTheme {
        Conversation(messages = mesgs)
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) {
            MessageCard(msg = it)
        }
    }
}


//@Preview(showBackground = true)
@Composable
fun MessageCard(msg: Message) {
    AppTheme {
        Box(
            modifier = Modifier
                .background(color = AppTheme.colors.background)
                .fillMaxSize()
                .padding(all = AppTheme.dimensions.marginMedium)
        ) {
            Surface(color = Color.Transparent) {
                var isSelected: Boolean by remember {
                    mutableStateOf(false)
                }
                val surfaceColor: Color by animateColorAsState(
                    targetValue = if (isSelected) AppTheme.colors.primary else AppTheme.colors.elementBorder
                )
                var showMore: Boolean by remember {
                    mutableStateOf(false)
                }
                val moreText: String = if (showMore) "${msg.author}" else "Show More"
                Row(
                    modifier = Modifier
                        .clickable(enabled = true) {
                            isSelected = !isSelected
                        }
                        .fillMaxWidth()
                        .background(
                            color = AppTheme.colors.surface,
                            shape = AppTheme.shapes.medium,
                        )
                        .border(
                            width = 1.dp,
                            color = surfaceColor,
                            shape = AppTheme.shapes.medium
                        ),
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.ic_person),
                        contentDescription = "author image",
                        modifier = Modifier
                            .padding(all = AppTheme.dimensions.paddingSmall)
                            .size(75.dp)
                            .clip(CircleShape)
                            .border(width = 1.dp, color = AppTheme.colors.elementBorder),
                    )
                    Spacer(
                        modifier = Modifier
                            .width(width = AppTheme.dimensions.paddingMedium)
                    )
                    Column(modifier = Modifier.clickable { isSelected = !isSelected }) {
                        Text(
                            text = msg.author,
                            color = AppTheme.colors.textPrimary,
                            style = AppTheme.typography.caption,
                            modifier = Modifier
                                .padding(top = AppTheme.dimensions.paddingSmall)
                        )
                        Spacer(
                            modifier = Modifier
                                .height(AppTheme.dimensions.paddingMedium)
                        )
                        Surface(
                            shape = AppTheme.shapes.medium,
                            color = surfaceColor
                        ) {
                            Text(
                                text = msg.body,
                                color = AppTheme.colors.textSecondary,
                                style = AppTheme.typography.body,
                                modifier = Modifier
                                    .padding(bottom = AppTheme.dimensions.paddingSmall)
                            )
                        }
                    }
                    OutlinedButton(
                        modifier = Modifier.padding(all = AppTheme.dimensions.paddingLarge),
                        onClick = { showMore = !showMore }) {
                        Text(text = moreText)
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    AppTheme {
        Greeting("Android")
    }
}