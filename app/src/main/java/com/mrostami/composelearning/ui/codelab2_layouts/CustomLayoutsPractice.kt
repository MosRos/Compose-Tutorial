package com.mrostami.composelearning.ui.codelab2_layouts

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mrostami.composelearning.ui.theme.AppTheme

val topics = listOf(
    "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
    "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
    "Religion", "Social sciences", "Technology", "TV", "Writing"
)

@Composable
fun TopicsGrid(
    items: List<String> = topics,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(
                start = AppTheme.dimensions.marginMedium,
                end = AppTheme.dimensions.marginMedium
            )
    ) {
        StaggeredGridLayout {
            for (topic in items) {
                Chip(
                    text = topic,
                    modifier = Modifier
                        .padding(
                            top = AppTheme.dimensions.marginSmall,
                            start = AppTheme.dimensions.marginSmall
                        )
                )
            }
        }
    }
}

@Composable
fun StaggeredGridLayout(
    modifier: Modifier = Modifier,
    rows: Int = 3,
    content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->
        val rowWidths = IntArray(rows) { 0 }
        val rowHeights = IntArray(rows) { 0 }

        val placeables = measurables.mapIndexed { index, measurable ->
            // Measure each child
            val placeable = measurable.measure(constraints)
            // Track the width and max height of each row
            val row = index % rows
            rowWidths[row] += placeable.width
            rowHeights[row] = Math.max(rowHeights[row], placeable.height)
            placeable
        }

        // x cord we have placed up to, per row
        val rowX = IntArray(rows) { 0 }
        val rowY = IntArray(rows) { 0 }

        // Grid's width is the widest row
        val width = rowWidths.maxOrNull()
            ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth

        // Grid's height is the sum of the tallest element of each row
        // coerced to the height constraints
        val height = rowHeights.sumOf { it }
            .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

        // Y of each row, based on the height accumulation of previous rows
        for (i in 1 until rows) {
            rowY[i] = rowY[i - 1] + rowHeights[i - 1]
        }

        // Set the size of the parent layout
        layout(width, height) {

            placeables.forEachIndexed { index, placeable ->
                val row = index % rows
                placeable.placeRelative(
                    x = rowX[row],
                    y = rowY[row]
                )
                rowX[row] += placeable.width
            }
        }
    }
}

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    text: String
) {
    var selected by remember { mutableStateOf(false) }
    val borderColor by animateColorAsState(
        targetValue = if (selected)
            Color.Magenta
        else
            AppTheme.colors.elementBorder
    )
    Card(
        modifier = modifier.background(
            color = AppTheme.colors.elementBackground
        ),
        border = BorderStroke(color = borderColor, width = 1.dp),
        shape = AppTheme.shapes.small,
    ) {
        Row(
            modifier = Modifier
                .clickable(enabled = true, onClick = { selected = !selected })
                .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .size(16.dp, 16.dp)
                    .background(color = borderColor)
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = text,
                style = AppTheme.typography.subtitle,
                color = AppTheme.colors.textSecondary
            )
        }
    }
}

@Composable
fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->
        val placeable: Placeable = measurable.measure(constraints)

        // check
        check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
        val firstBaseline = placeable[FirstBaseline]

        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
        val height = placeable.height + placeableY

        layout(placeable.width, height) {
            placeable.placeRelative(0, placeableY)
        }
    }
)


@Composable
fun CustomTextWithPaddingToBaselineNormal(
    modifier: Modifier = Modifier
) {
    Text(text = "NormalBaselinePadding", Modifier.firstBaselineToTop(16.dp))
}

@Composable
fun MyOwnLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(content = content, modifier = modifier) { measurables, constraints ->
        val placeables = measurables.map {
            it.measure(constraints)
        }

        var yPosition = 0

        layout(constraints.maxWidth, constraints.maxHeight) {
            // Place children in the parent layout
            placeables.forEach { placeable ->
                // Position item on the screen
                placeable.placeRelative(x = 0, y = yPosition)

                // Record the y co-ord placed up to
                yPosition += placeable.height
            }
        }
    }
}

//@Composable
//fun ScrollableRow(
//    modifier: Modifier = Modifier,
//    scrollState: ScrollState = rememberScrollState(0),
//    horizontalArrangement: Arrangement.Horizontal = Arrangement.Start,
//    verticalGravity: Alignment.Vertical = Alignment.Top,
//    reverseScrollDirection: Boolean = false,
//    isScrollEnabled: Boolean = true,
////    contentPadding: InnerP = InnerPadding(0.dp),
//    children: @Composable RowScope.() -> Unit
//) {
//
//}

@Composable
fun ConstraintPractice() {
        ConstraintLayout(modifier = Modifier
            .padding(top = 55.dp)
            .fillMaxSize()
    ) {
        val (customText, customColumn, staggeredGrid) = createRefs()

        CustomTextWithPaddingToBaselineNormal(modifier = Modifier.constrainAs(customText) {
            top.linkTo(parent.top, margin = 16.dp)
            start.linkTo(parent.start, margin = 16.dp)
            end.linkTo(parent.end, margin = 16.dp)
        })
        MyOwnLayout(
            modifier = Modifier.constrainAs(customColumn) {
                top.linkTo(customText.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
                end.linkTo(parent.end, margin = 16.dp)
            }
        ) {
            Text(text = "Text1")
            Text(text = "Text2")
            Text(text = "Text3")
            Text(text = "Text4")
        }
    }
}