package io.github.louistsaitszho.fluent.component

import android.util.Log
import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.padding
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import io.github.louistsaitszho.fluent.design_language.Colors
import io.github.louistsaitszho.fluent.design_language.Typography
import io.github.louistsaitszho.fluent.isDarkTheme

@Composable
fun Button(modifier: Modifier = Modifier, text: String, onClick: () -> Unit) {
    val isDarkTheme = isDarkTheme()
    Log.d("Button", "isDarkTheme = $isDarkTheme")
    Clickable(modifier = modifier, onClick = onClick) {
        val backgroundColor = if (isDarkTheme) Colors.DarkComTint10 else Colors.com
        Box(modifier = Modifier, backgroundColor = backgroundColor, shape = RoundedCornerShape(2.dp)) {
            val textColor = if (isDarkTheme) Color.Black else Color.White
            Text(
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp),
                text = text.capitalize(),
                style = Typography.body2,
                color = textColor
            )
        }
    }
}

@Preview(name = "Primary Default", group = "Primary")
@Composable
fun PreviewPrimaryDefault() {
    Button(text = "Default") { }
}