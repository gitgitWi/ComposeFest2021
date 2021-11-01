package dev.tutorials.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.tutorials.compose_basics.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // instead of using XML, call Composable funcs
        setContent {
            BasicsCodelabTheme {
                MyApp()
            }
        }
    }
}

@Composable
private fun MyApp(color: Color = MaterialTheme.colors.background) {
    // 배경색만 사용자 정의하고, 텍스트색은 검-흰 중 MaterialTheme에서 알아서 제공
    Surface(color = color) {
        Greeting("gitgitWi")
    }
}

@Composable
private fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp()
    }
}

@Preview(showBackground = true, name = "second default preview")
@Composable
fun DefaultPreview2() {
    BasicsCodelabTheme {
        MyApp(MaterialTheme.colors.secondary)
    }
}
