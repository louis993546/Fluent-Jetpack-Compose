package io.github.louistsaitszho.fluent

import android.util.Log
import androidx.compose.Composable
import androidx.compose.Providers
import androidx.compose.ambientOf
import androidx.ui.foundation.isSystemInDarkTheme
import androidx.ui.material.Surface

@Composable
fun FluentTheme(
//    setting: ThemeSetting = ThemeSetting.System,
    content: @Composable() () -> Unit
) {
//    val isDark =
//        setting == ThemeSetting.Dark || (setting == ThemeSetting.System && isSystemInDarkTheme())
    val isDark = isSystemInDarkTheme()
    Log.d("FluentTheme", "isDark = $isDark")
    Providers(IsDarkThemeAmbient provides isDark, children = content)
    Surface() {

    }
}

//enum class ThemeSetting {
//    Light, Dark, System
//}

val IsDarkThemeAmbient = ambientOf { false }

@Composable
fun isDarkTheme() = IsDarkThemeAmbient.current
