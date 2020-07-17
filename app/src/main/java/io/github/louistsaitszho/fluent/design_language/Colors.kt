package io.github.louistsaitszho.fluent.design_language

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Box
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import io.github.louistsaitszho.fluent.design_language.Colors.communicationBlue
import io.github.louistsaitszho.fluent.design_language.Colors.defaultGrayRamp
import kotlin.math.roundToInt

object Colors {
    val comShade30 = Color(0xFF004578)
    val comShade20 = Color(0xFF005A9E)
    val comShade10 = Color(0xFF106EBE)
    val com = Color(0xFF0078D4)
    val comTint10 = Color(0xFF2B88D8)
    val comTint20 = Color(0xFFC7E0F4)
    val comTint30 = Color(0xFFDEECF9)
    val comTint40 = Color(0xFFEFF6FC)

    val communicationBlue = mapOf(
        "COM shade 30" to comShade30,
        "COM shade 20" to comShade20,
        "COM shade 10" to comShade10,
        "COM primary" to com,
        "COM tint 10" to comTint10,
        "COM tint 20" to comTint20,
        "COM tint 30" to comTint30,
        "COM tint 40" to comTint40
    )

    val black = Color.Black
    val gray950 = Color(0xFF141414)
    val gray900 = Color(0xFF212121)
    val gray800 = Color(0xFF292929)
    val gray700 = Color(0xFF303030)
    val gray600 = Color(0xFF404040)
    val gray500 = Color(0xFF6E6E6E)
    val gray400 = Color(0xFF919191)
    val gray300 = Color(0xFFACACAC)
    val gray200 = Color(0xFFC8C8C8)
    val gray100 = Color(0xFFE1E1E1)
    val gray50 = Color(0xFFF1F1F1)
    val gray25 = Color(0xFFF1F1F1)
    val white = Color.White

    val defaultGrayRamp = mapOf(
        "Black" to black,
        "Gray 950" to gray950,
        "Gray 900" to gray900,
        "Gray 800" to gray800,
        "Gray 700" to gray700,
        "Gray 600" to gray600,
        "Gray 500" to gray500,
        "Gray 400" to gray400,
        "Gray 300" to gray300,
        "Gray 200" to gray200,
        "Gray 100" to gray100,
        "Gray 50" to gray50,
        "Gray 25" to gray25,
        "White" to white
    )

    val dangerShade30 = Color(0xFF6A1616)
    val dangerShade20 = Color(0xFF8B1C1C)
    val dangerShade10 = Color(0xFFBB2424)
    val dangerPrimary = Color(0xFFD92C2C)
    val dangerTint10 = Color(0xFFEC5454)
    val dangerTint20 = Color(0xFFEB9191)
    val dangerTint30 = Color(0xFFFACFCF)
    val dangerTint40 = Color(0xFFFFEBEB)
    val warningShade30 = Color(0xFF745300)
    val warningShade20 = Color(0xFF8A6B00)
    val warningShade10 = Color(0xFFDCAB00)
    val warningPrimary = Color(0xFFFFD335)
    val warningTint10 = Color(0xFFFFD349)
    val warningTint20 = Color(0xFFFEDE78)
    val warningTint30 = Color(0xFFFFEBAB)
    val warningTint40 = Color(0xFFFFF2C8)

    val DarkComTint10 = com

    val whiteTextColors = listOf(
        comShade30,
        comShade20,
        comShade10,
        com,
        black,
        gray950,
        gray900,
        gray800,
        gray700,
        gray600,
        gray500,
        gray400,
        dangerShade30,
        dangerShade20,
        dangerShade10,
        dangerPrimary,
        warningShade30,
        warningShade20
    )
}

public fun Color.getTextColor(): Color =
    if (Colors.whiteTextColors.contains(this)) Colors.white else Colors.black

// TODO how to get human friendly hex code?

@ExperimentalUnsignedTypes
public fun Color.toHexCode(): String = "#${red.toHex()}${green.toHex()}${blue.toHex()}"

@ExperimentalUnsignedTypes
private fun Float.toHex() = (this * 256).toUInt().toString(16).capitalize()

@Composable
private fun Swatch(name: String, color: Color) {
    Box(modifier = Modifier.size(width = 240.dp, height = 80.dp), backgroundColor = color) {
        Column(
            modifier = Modifier.fillMaxHeight().padding(start = 16.dp, top = 8.dp, bottom = 10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = name, color = color.getTextColor())
            Text(text = color.toHexCode(), color = color.getTextColor())
        }
    }
}

@Preview(widthDp = 960)
@Composable
fun PreviewCommunicationBlues() {
    PreviewSwatchList(colorMap = communicationBlue)
}

@Preview(widthDp = 960)
@Composable
fun PreviewDefaultGrayRamp() {
    PreviewSwatchList(colorMap = defaultGrayRamp)
}

@Composable
fun PreviewSwatchList(colorMap: Map<String, Color>) {
    FlowRow {
        colorMap.forEach { (name, color) ->
            Swatch(name = name, color = color)
        }
    }
}