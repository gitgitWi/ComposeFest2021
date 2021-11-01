package dev.tutorials.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
                val names = listOf("World", "Space")
                Column {
                    for (name in names)
                        MyApp(name)
                }
            }
        }
    }
}

@Composable
private fun MyApp(name: String, color: Color = MaterialTheme.colors.primary) {
    // 배경색만 사용자 정의하고, 텍스트색은 검-흰 중 MaterialTheme에서 알아서 제공
    Surface(color = color) {
        Greeting(name)
    }
}

@Composable
private fun Greeting(name: String) {
    // remember를 사용해 mutable state를 기억, recompositions 방지
    val isExpanded = remember { mutableStateOf(false) }
    val extraPadding = if (isExpanded.value) 48.dp else 0.dp

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(bottom = extraPadding)
        ) {
            Text(text = "Halo,")
            Text(text = name)
        }
        OutlinedButton(onClick = { isExpanded.value = !isExpanded.value }) {
            Text(text = if (isExpanded.value) "Show less" else "Show more!")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        MyApp("gitgitWi")
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun ColumnPreview() {
    BasicsCodelabTheme {
        val names = listOf<String>("World", "Space")
        Column(modifier = Modifier.padding(vertical = 4.dp)) {
            for (name in names) {
                Greeting(name = name)
            }
        }
    }
}
