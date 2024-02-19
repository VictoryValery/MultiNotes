package com.example.multinotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.common.domain.Note
import com.example.dashboard.screens.DashboardScreen
import com.example.dashboard.screens.presentation.DashboardState
import com.example.multinotes.ui.theme.MultiNotesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiNotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DashboardScreen(
                        DashboardState(
                            userName = "Victory",
                            notes = listOf(
                                Note(
                                    id = 1,
                                    title = "1long title for my note",
                                    content = "Long content for my note double whisky and repeat please"
                                ),
                                Note(
                                    id = 12,
                                    title = "2long title for my note",
                                    content = "Long content for my note double whisky and repeat please"
                                ),
                                Note(
                                    id = 13,
                                    title = "3long title for my note",
                                    content = "Long content for my note double whisky and repeat please"
                                ),
                                Note(
                                    id = 14,
                                    title = "4long title for my note",
                                    content = "Long content for my note double whisky and repeat please"
                                ),
                                Note(
                                    id = 15,
                                    title = "5long title for my note",
                                    content = "Long content for my note double whisky and repeat please"
                                )
                            )
                        )
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiNotesTheme {
        Greeting("Android")
    }
}