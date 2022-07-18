package com.goranssonappdev.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.goranssonappdev.constraintlayout.ui.theme.ConstraintLayoutTheme
import kotlinx.coroutines.NonDisposableHandle.parent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConstraintLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    ConstraintLayout(Modifier.size(width = 400.dp, height = 200.dp)) {
        val (button1, button2, button3) = createRefs()

        createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.SpreadInside)


        MyButton(text = "Button1", Modifier.constrainAs(button1) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button2", Modifier.constrainAs(button2) {
            centerVerticallyTo(parent)
        })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            centerVerticallyTo(parent)
        })

    }
}

// Adding a custom button composable
@Composable
fun MyButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = { },
        modifier = modifier
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ConstraintLayoutTheme {
        MainScreen()
    }
}