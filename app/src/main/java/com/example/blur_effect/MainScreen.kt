package com.example.blur_effect

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController
) {
    val checked by remember { mutableStateOf(true) }
    val animatedBlur by animateDpAsState(targetValue = if (checked) 10.dp else 0.dp, label = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF181A18)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.blur(
                radius = animatedBlur,
                edgeTreatment = BlurredEdgeTreatment.Unbounded
            ),
            text = "Blur Effect",
            color = Color.White,
            fontSize = MaterialTheme.typography.displayLarge.fontSize
        )
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.2f)
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(20.dp))
                    .size(150.dp)
                    .blur(
                        radius = animatedBlur,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded
                    ),
                elevation = CardDefaults.cardElevation(16.dp),
                onClick = {
                    navController.navigate("SecondScreen")
                }
            ) {
                Image(
                    modifier = Modifier.height(200.dp),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Switch(checked = checked, onCheckedChange = { !checked })
    }
}