package io.github.louistsaitszho.fluent.component

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.ripple.ripple
import androidx.ui.res.vectorResource
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import io.github.louistsaitszho.fluent.R
import io.github.louistsaitszho.fluent.design_language.*

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    color: AppBarColor = AppBarColor.Blue,
    personaUrl: String? = null
) {
    val textColor = color.color.getTextColor()
    Box(
        modifier = modifier.preferredHeight(56.dp).fillMaxWidth(),
        backgroundColor = color.color
    ) {
        Row(
            modifier = Modifier.padding(start = 16.dp, end = 8.dp),
            verticalGravity = Alignment.CenterVertically
        ) {
            // Image
            Column(
                modifier = Modifier.fillMaxHeight().padding(top = 5.dp, bottom = 8.dp)
            ) {
                Text(text = title, style = Typography.title1, color = textColor)
                if (!subtitle.isNullOrBlank()) {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = subtitle,
                        style = Typography.caption,
                        color = textColor
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(asset = vectorResource(id = R.drawable.ic_more_vert), tint = Colors.white)
        }
    }
}

enum class AppBarColor(val color: Color) {
    Blue(Colors.com), White(Colors.white)
}

data class OverflowItem(val id: String, val text: String)

@Composable
fun OverflowMenu(
    modifier: Modifier = Modifier,
    items: List<OverflowItem>,
    onClick: (String) -> Unit
) {
    Box(
        modifier = modifier.elevate(Distance.z06).wrapContentWidth(align = Alignment.Start),
        backgroundColor = Colors.white
    ) {
        Column {
            items.forEach {
                OverflowMenuItem(
                    child = { Text(text = it.text) },
                    onClick = { onClick(it.id) }
                )
            }
        }
    }
}

@Composable
private fun OverflowMenuItem(
    modifier: Modifier = Modifier,
    child: @Composable() () -> Unit,
    onClick: () -> Unit
) {
    Clickable(modifier = modifier.ripple(), onClick = onClick) {
        Box(
            modifier = Modifier.preferredHeight(56.dp),
            padding = 8.dp,
            gravity = ContentGravity.CenterStart
        ) {
            child()
        }
    }
}

@Preview(name = "Primary Default w/ Persona, 3 actions, overflow, Subtitle", group = "Primary")
@Composable
fun PreviewMaxedOutAppBar() {
    Column {
        StatusBar()
        AppBar(title = "Title", subtitle = "Subtitle")
    }
}

@Preview
@Composable
fun PreviewOverflowMenu() {
    OverflowMenu(items = listOf(
        OverflowItem(id = "1", text = "Action 1"),
        OverflowItem(id = "2", text = "Action 2"),
        OverflowItem(id = "3", text = "Action 3")
    ), onClick = {})
}

@Composable
private fun StatusBar() {
    Box(modifier = Modifier.fillMaxWidth().preferredHeight(24.dp), backgroundColor = Colors.com) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(end = 8.dp),
            horizontalArrangement = Arrangement.End,
            verticalGravity = Alignment.CenterVertically
        ) {
            Text(text = "10:28", color = Colors.white, style = Typography.body2)
        }
    }
}