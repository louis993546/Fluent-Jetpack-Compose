package io.github.louistsaitszho.fluent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Text
import androidx.ui.core.dp
import androidx.ui.core.setContent
import androidx.ui.foundation.shape.DrawShape
import androidx.ui.foundation.shape.border.Border
import androidx.ui.foundation.shape.border.DrawBorder
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.Font
import androidx.ui.text.font.FontFamily
import androidx.ui.text.font.FontWeight
import androidx.ui.tooling.preview.Preview
import io.github.louistsaitszho.fluent.Something.*

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
        DefaultButton(text = "Primary Rest", level = ButtonLevel.PRIMARY, state = ButtonState.REST)
        DefaultButton(text = "Primary Pressed", level = ButtonLevel.PRIMARY, state = ButtonState.PRESSED)
        DefaultButton(text = "Primary Focus", level = ButtonLevel.PRIMARY, state = ButtonState.FOCUS)
        DefaultButton(text = "Primary Disabled", level = ButtonLevel.PRIMARY, state = ButtonState.DISABLED)

        DefaultButton(text = "Standard Rest", level = ButtonLevel.STANDARD, state = ButtonState.REST)
        DefaultButton(text = "Standard Pressed", level = ButtonLevel.STANDARD, state = ButtonState.PRESSED)
        DefaultButton(text = "Standard Focus", level = ButtonLevel.STANDARD, state = ButtonState.FOCUS)
        DefaultButton(text = "Standard Disabled", level = ButtonLevel.STANDARD, state = ButtonState.DISABLED)
    }
}

enum class Something {
    PRIMARY_REST,
    PRIMARY_FOCUS,
    PRIMARY_PRESSED,
    PRIMARY_DISABLED,
    STANDARD_REST,
    STANDARD_FOCUS,
    STANDARD_PRESSED,
    STANDARD_DISABLED,
}

private fun something(level: ButtonLevel, state: ButtonState): Something = when {
    level == ButtonLevel.PRIMARY && state == ButtonState.REST -> PRIMARY_REST
    level == ButtonLevel.PRIMARY && state == ButtonState.FOCUS -> PRIMARY_FOCUS
    level == ButtonLevel.PRIMARY && state == ButtonState.PRESSED -> PRIMARY_PRESSED
    level == ButtonLevel.PRIMARY && state == ButtonState.DISABLED -> PRIMARY_DISABLED
    level == ButtonLevel.STANDARD && state == ButtonState.REST -> STANDARD_REST
    level == ButtonLevel.STANDARD && state == ButtonState.FOCUS -> STANDARD_FOCUS
    level == ButtonLevel.STANDARD && state == ButtonState.PRESSED -> STANDARD_PRESSED
    level == ButtonLevel.STANDARD && state == ButtonState.DISABLED -> STANDARD_DISABLED
    else -> TODO("technically impossible")
}

// https://developer.microsoft.com/en-us/fabric#/controls/web/button
@Composable
fun DefaultButton(
        text: String,
        level: ButtonLevel = ButtonLevel.STANDARD,
        state: ButtonState = ButtonState.REST
) {
    val backgroundColor = when (something(level, state)) {
        PRIMARY_PRESSED -> Color(red = 0, green = 90, blue = 198)
        STANDARD_PRESSED -> Color(red = 237, green = 235, blue = 233)
        PRIMARY_REST, PRIMARY_FOCUS -> CyanBlue10
        PRIMARY_DISABLED, STANDARD_DISABLED -> Color(red = 243, green = 242, blue = 241)
        STANDARD_REST, STANDARD_FOCUS -> Color.White
    }

    val textColor = when (something(level, state)) {
        PRIMARY_REST, PRIMARY_FOCUS, PRIMARY_PRESSED -> Color.White
        PRIMARY_DISABLED, STANDARD_DISABLED -> Color(0xFFA19F9D)
        STANDARD_REST, STANDARD_FOCUS -> Color(0XFF323130)
        STANDARD_PRESSED -> Color(0xFF201F1E)
    }

    val borderColor = Color.White

    Column(modifier = MinHeight(30.dp)) {
        // TODO text style
        Stack(modifier = MinSize(minWidth = 80.dp, minHeight = 32.dp)) {
            this.aligned(alignment = Alignment.Center) {
                DrawShape(shape = RoundedCornerShape(2.dp), color = backgroundColor)
                DrawBorder(shape = RoundedCornerShape(2.dp), border = Border(borderColor, 1.dp))
                Padding(left = 16.dp, right = 16.dp, top = 6.dp, bottom = 6.dp) {
                    Text(
                        text = text,
                        style = TextStyle(color = textColor, fontFamily = SegoeUiFontFamily)
                    )
                }
            }
        }
    }
}

val SegoeUiFontFamily = FontFamily(
    Font("segoeui.ttf", FontWeight.Normal),
    Font("segoeuib.ttf", FontWeight.Bold),
    Font("segoeuil.ttf", FontWeight.W100),
    Font("segoeuisl.ttf", FontWeight.W200),
    Font("seguisb.ttf", FontWeight.W700)
)

enum class ButtonLevel {
    PRIMARY, STANDARD
}

enum class ButtonState {
    REST, FOCUS, PRESSED, DISABLED
}

@Preview("MyScreen preview")
@Composable
fun DefaultPreview() {
    FluentApp()
}

// https://developer.microsoft.com/en-us/fabric#/styles/web/colors/shared
val PinkRed10 = Color(0xFF750B1C)
val Red20 = Color(0xFFA4262C)
val Red10 = Color(0xFFD13438)
val RedOrange10 = Color(0xFFDA3B01)
val Orange30 = Color(0xFF8E562E)
val Orange20 = Color(0xFFCA5010)
val Orange10 = Color(0xFFFFAA44)
val Yellow10 = Color(0xFFFCE100)
val OrangeYellow20 = Color(0xFF986F0B)
val OrangeYellow10 = Color(0XFFC19C00)
val YellowGreen10 = Color(0xFF8CDB18)
val Green20 = Color(0xFF0B6A0B)
val Green10 = Color(0xFF498205)
val GreenCyan10 = Color(0xFF00AD56)
val Cyan30 = Color(0xFF005B70)
val Cyan20 = Color(0xFF038387)
val Cyan10 = Color(0xFF00B7C3)
val CyanBlue20 = Color(0xFF004C8C)
val CyanBlue10 = Color(0xFF0078D4)
val Blue10 = Color(0xFF4F6BED)
val BlueMagenta30 = Color(0xFF5C2E91)
val BlueMagenta20 = Color(0xFF8764B8)
val BlueMagenta10 = Color(0xFF8378DE)
val Magenta20 = Color(0xFF881798)
val Magenta10 = Color(0xFFC239B3)
val MagentaPink20 = Color(0xFF9B0062)
val MagentaPink10 = Color(0xFFE3008C)
val Gray40 = Color(0xFF393939)
val Gray30 = Color(0xFF7A7574)
val Gray20 = Color(0xFF69797E)
val Gray10 = Color(0xFFA0AEB2)
