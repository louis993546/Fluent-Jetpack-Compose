package io.github.louistsaitszho.fluent

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import androidx.ui.core.setContent
import androidx.ui.tooling.preview.Preview
import io.github.louistsaitszho.fluent.component.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FluentTheme {
                Demo { execute(command = it) }
            }
        }
    }

    private fun execute(command: Command) {
        when (command) {
            is Command.ChangeTheme -> setAppTheme(appTheme = command.newTheme)
        }.exhaustive
    }

    private fun setAppTheme(appTheme: AppTheme) {
        PreferenceManager.getDefaultSharedPreferences(this)
            .edit { putString("appTheme", appTheme.name) }
    }
}

sealed class Command {
    data class ChangeTheme(val newTheme: AppTheme) : Command()
}

@Composable
fun Demo(callback: (Command) -> Unit) {
    Button(text = "Default") {

    }
}


@Preview("Preview Demo")
@Composable
fun DefaultPreview() {
    Demo {}
}

enum class AppTheme {
    Light, Dark, System
}

/**
 * Add the to end of non-return when to ensure it is exhaustive at compile-time
 */
@Suppress("unused")
val Any?.exhaustive
    get() = Unit