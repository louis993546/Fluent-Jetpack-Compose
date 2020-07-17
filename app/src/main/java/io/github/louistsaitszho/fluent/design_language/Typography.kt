package io.github.louistsaitszho.fluent.design_language

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.sp

object Typography {
    val caption: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    val body2: TextStyle = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    )
    val body1: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
    val subheading2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )
    val subheading1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    val heading = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp
    )
    val title2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )
    val title1 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )
    val headline = TextStyle(
        fontWeight = FontWeight.Light,
        fontSize = 28.sp
    )
}

private const val copy = "The quick brown fox jumps over the lazy dog"

@Preview(name = "Caption")
@Composable
fun PreviewCaption() {
    Text(text = copy, style = Typography.caption)
}

@Preview(name = "Body 2")
@Composable
fun PreviewBody2() {
    Text(text = copy, style = Typography.body2)
}

@Preview(name = "Body 1")
@Composable
fun PreviewBody1() {
    Text(text = copy, style = Typography.body1)
}

@Preview(name = "Subheading 2")
@Composable
fun PreviewSubheading2() {
    Text(text = copy, style = Typography.subheading2)
}

@Preview(name = "Subheading 1")
@Composable
fun PreviewSubheading1() {
    Text(text = copy, style = Typography.subheading1)
}

@Preview(name = "Heading")
@Composable
fun PreviewHeading() {
    Text(text = copy, style = Typography.heading)
}

@Preview(name = "Title 2")
@Composable
fun PreviewTitle2() {
    Text(text = copy, style = Typography.title2)
}

@Preview(name = "Title 1")
@Composable
fun PreviewTitle1() {
    Text(text = copy, style = Typography.title1)
}

@Preview(name = "Headline")
@Composable
fun PreviewHeadline() {
    Text(text = copy, style = Typography.headline)
}