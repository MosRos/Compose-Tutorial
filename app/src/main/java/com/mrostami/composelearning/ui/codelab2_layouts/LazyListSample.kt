package com.mrostami.composelearning.ui.codelab2_layouts

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.materialIcon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mrostami.composelearning.R
import com.mrostami.composelearning.ui.theme.AppTheme
import kotlinx.coroutines.launch


@Composable
fun PostsList(names: List<String> = List(300) { "$it" }) {
    val scrollState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    var scrollPosition by remember {
        mutableStateOf(0)
    }
    Box(modifier = Modifier.padding(top = 40.dp)) {
        LazyColumn(
            modifier = Modifier
                .padding(vertical = AppTheme.dimensions.paddingLarge),
            state = scrollState
        ) {
            items(items = names) { name ->
                Greeting(name = name)
            }
            scrollPosition = scrollState.firstVisibleItemIndex
        }
        var isAtTop: Boolean = if (scrollPosition < 20) true else false
        FloatingActionButton(
            onClick = {
                coroutineScope.launch {
                    if (isAtTop) {
                        scrollState.animateScrollToItem(names.size - 1)
                    } else {
                        scrollState.animateScrollToItem(0)
                    }
                }
            },
            modifier = Modifier
                .padding(all = AppTheme.dimensions.marginMedium)
                .align(alignment = Alignment.BottomEnd),
            backgroundColor = AppTheme.colors.primary
        ) {
            var upOrDownIcon: ImageVector =
                if (isAtTop) Icons.Filled.ArrowDownward else Icons.Filled.ArrowUpward
            Icon(imageVector = upOrDownIcon, contentDescription = "")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Card(
        backgroundColor = AppTheme.colors.surface,
        modifier = Modifier.padding(
            horizontal = AppTheme.dimensions.marginMedium,
            vertical = AppTheme.dimensions.paddingLarge
        )
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {
    var expanded by remember { mutableStateOf(false) }

    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
    ) {
        Surface(
            modifier = Modifier.size(55.dp),
            shape = CircleShape,
            color = AppTheme.colors.elementBackground,
            border = BorderStroke(width = 1.dp, color = AppTheme.colors.elementBorder)
        ) {
            Image(
                painter = rememberImagePainter(
                    data = "https://picsum.photos/100",
                ),
                contentDescription = "post image",
                modifier = Modifier.size(55.dp),
            )
        }
        Spacer(modifier = Modifier.width(AppTheme.dimensions.paddingMedium))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(12.dp)
        ) {
            Text(
                text = "Hello, ",
                color = AppTheme.colors.textPrimary,
                style = AppTheme.typography.title
            )
            Text(
                text = name,
                color = AppTheme.colors.textSecondary,
                style = AppTheme.typography.h1
            )
            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                    color = AppTheme.colors.textSecondary,
                    style = AppTheme.typography.body
                )
            }
        }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                },
                tint = AppTheme.colors.icon
            )
        }
    }
}