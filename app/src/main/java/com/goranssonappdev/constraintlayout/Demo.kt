package com.goranssonappdev.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ConstraintLayoutDemo() {

    ConstraintLayout(Modifier
        .size(width = 200.dp, height = 300.dp)
        .background(Color.Green)) {

        // Single reference
        val text1 = createRef()

        // Assigning a reference
        // Adding constraints
//        Text(text = "Hello" , modifier = Modifier.constrainAs(text1) {
//            // Constraints here
//            top.linkTo(parent.top, margin = 16.dp)
//            bottom.linkTo(parent.bottom, margin = 16.dp)
//        })

        // Multiple constraints
//        Text(text = "Hello", modifier = Modifier.constrainAs(text1) {
//            linkTo(parent.top, parent.bottom, bias = 0.8f)
//            linkTo(button1.end, button2.start)
//        })

        // Centered horizontally and vertically
//        Text(text = "text1", modifier = Modifier.constrainAs(text1) {
//            centerVerticallyTo(text2)
//            centerHorizontallyTo(parent)
//        })

        // centerAround()
//        Text(text = "text1", modifier = Modifier.constrainAs(text1) {
//            centerAround(text2.end)
//            centerAround(text4.top)
//        })

        // Multiple references
        val (button, text2, text3) = createRefs()

    }
}