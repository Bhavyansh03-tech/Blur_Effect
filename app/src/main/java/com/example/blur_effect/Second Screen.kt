package com.example.blur_effect

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun SecondScreen() {

    val isBlurred = remember { mutableStateOf(false) }
    val animatedBlur by animateDpAsState(targetValue = if (isBlurred.value) 10.dp else 0.dp, label = "...")
    val scrollState = rememberScrollState()

    val imageList = listOf(
        R.drawable.img,
        R.drawable.img1,
        R.drawable.img2,
        R.drawable.img4,
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        imageList.forEach { imageResId ->
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
                    .blur(
                        radius = animatedBlur,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    )
                    .clickable {
                        isBlurred != isBlurred
                    },
                painter = painterResource(id = imageResId),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}