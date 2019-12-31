package io.github.louistsaitszho.fluent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.RectangleShape
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.border.DrawBorder
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.surface.Surface
import androidx.ui.text.TextStyle
import androidx.ui.tooling.preview.Preview

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FluentApp()
        }
    }
}

@Composable
fun FluentApp() {
    Column {
        DefaultButton(text = "Primary", level = ButtonLevel.PRIMARY, enabled = true)
        DefaultButton(text = "Primary", level = ButtonLevel.PRIMARY, enabled = false)
        DefaultButton(text = "Standard", enabled = true)
        DefaultButton(text = "Standard", enabled = false)
    }
}

enum class Something {
    ENABLED_PRIMARY_UNCHECKED, ENABLED_STANDARD_UNCHECKED,
    ENABLED_PRIMARY_CHECKED, ENABLED_STANDARD_CHECKED,
    DISABLED_PRIMARY_UNCHECKED, DISABLED_STANDARD_UNCHECKED,
    DISABLED_PRIMARY_CHECKED, DISABLED_STANDARD_CHECKED
}

private fun something(level: ButtonLevel, enabled: Boolean, checked: Boolean): Something = when {
    enabled && level == ButtonLevel.PRIMARY && !checked -> Something.ENABLED_PRIMARY_UNCHECKED
    enabled && level == ButtonLevel.STANDARD && !checked -> Something.ENABLED_STANDARD_UNCHECKED
    enabled && level == ButtonLevel.PRIMARY && checked -> Something.ENABLED_PRIMARY_CHECKED
    enabled && level == ButtonLevel.STANDARD && checked -> Something.ENABLED_STANDARD_CHECKED
    !enabled && level == ButtonLevel.PRIMARY && !checked -> Something.DISABLED_PRIMARY_UNCHECKED
    !enabled && level == ButtonLevel.STANDARD && !checked -> Something.DISABLED_STANDARD_UNCHECKED
    !enabled && level == ButtonLevel.PRIMARY && checked -> Something.DISABLED_PRIMARY_CHECKED
    !enabled && level == ButtonLevel.STANDARD && checked -> Something.DISABLED_STANDARD_CHECKED
    else -> TODO("technically impossible")
}

// https://developer.microsoft.com/en-us/fabric#/controls/web/button
@Composable
fun DefaultButton(
        text: String,
        level: ButtonLevel = ButtonLevel.STANDARD,
        enabled: Boolean = true,
        checked: Boolean = false
) {
    val backgroundColor = when (something(level, enabled, checked)) {
        Something.ENABLED_PRIMARY_UNCHECKED -> Color(red = 0, green = 120, blue = 212)
        Something.ENABLED_PRIMARY_CHECKED -> Color(red = 0, green = 90, blue = 158)
        Something.ENABLED_STANDARD_UNCHECKED -> Color(red = 255, green = 255, blue = 255)
        Something.ENABLED_STANDARD_CHECKED -> Color(red = 237, green = 235, blue = 233)
        Something.DISABLED_PRIMARY_UNCHECKED, Something.DISABLED_STANDARD_UNCHECKED, Something.DISABLED_PRIMARY_CHECKED, Something.DISABLED_STANDARD_CHECKED -> Color(red = 243, green = 242, blue = 241)
    }

    val textColor = when (something(level, enabled, checked)) {
        Something.ENABLED_STANDARD_UNCHECKED -> Color(red = 50, green = 49, blue = 48)
        Something.ENABLED_STANDARD_CHECKED -> Color(red = 32, green = 31, blue = 30)
        Something.ENABLED_PRIMARY_UNCHECKED, Something.ENABLED_PRIMARY_CHECKED -> Color(red = 255, green = 255, blue = 255)
        Something.DISABLED_PRIMARY_UNCHECKED, Something.DISABLED_STANDARD_UNCHECKED, Something.DISABLED_PRIMARY_CHECKED, Something.DISABLED_STANDARD_CHECKED -> Color(red = 161, green = 159, blue = 157)
    }

    val borderColor = when (something(level, enabled, checked)) {
        Something.ENABLED_PRIMARY_UNCHECKED, Something.ENABLED_PRIMARY_CHECKED -> Color(red = 0, green = 120, blue = 212)
        Something.ENABLED_STANDARD_UNCHECKED, Something.ENABLED_STANDARD_CHECKED -> Color(red = 138, green = 136, blue = 134)
        Something.DISABLED_PRIMARY_UNCHECKED, Something.DISABLED_STANDARD_UNCHECKED, Something.DISABLED_PRIMARY_CHECKED, Something.DISABLED_STANDARD_CHECKED -> Color(red = 243, green = 242, blue = 241)
    }

    Column(modifier = MinHeight(30.dp)) {
        // TODO text style
        Stack(modifier = MinSize(minWidth = 80.dp, minHeight = 30.dp)) {
            this.aligned(alignment = Alignment.Center) {
                DrawShape(shape = RectangleShape, color = backgroundColor)
                DrawBorder(shape = RectangleShape, border = Border(borderColor, 1.dp))
                Padding(left = 16.dp, right = 16.dp) {
                    Text(text = text, style = TextStyle(color = textColor))
                }
            }
        }
    }

}

enum class ButtonLevel {
    PRIMARY, STANDARD
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    FluentApp()
}