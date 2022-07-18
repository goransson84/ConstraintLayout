package com.goranssonappdev.constraintlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
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
    ConstraintLayout(Modifier.size(width = 350.dp, height = 220.dp)) {
        val (button1, button2, button3) = createRefs()

        val barrier = createEndBarrier(button1, button2)

        MyButton(text = "Button1",
            Modifier
                .width(250.dp)
                .constrainAs(button1) {
                    top.linkTo(parent.top, margin = 30.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                })

        MyButton(text = "Button2",
            Modifier
                .width(150.dp)
                .constrainAs(button2) {
                    top.linkTo(button1.bottom, margin = 20.dp)
                    start.linkTo(parent.start, margin = 8.dp)
                })

        MyButton(text = "Button3", Modifier.constrainAs(button3) {
            linkTo(parent.top, parent.bottom, topMargin = 8.dp, bottomMargin = 8.dp)
            linkTo(button1.end, parent.end, startMargin = 30.dp, endMargin = 8.dp)

            start.linkTo(barrier, margin = 30.dp)

            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
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