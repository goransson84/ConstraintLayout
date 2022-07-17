package com.goranssonappdev.constraintlayout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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

        // Multiple references
        val (button, text2, text3) = createRefs()

    }
}