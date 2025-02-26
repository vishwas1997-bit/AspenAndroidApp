package com.aspen_android_app.screen

import android.graphics.BlurMaskFilter.Blur
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aspen_android_app.R
import com.aspen_android_app.navigation.AspenScreen
import com.aspen_android_app.ui.theme.Blue
import com.aspen_android_app.ui.theme.MontserratFontFamily

@Composable
fun AspenIntro(navigateToDashboard: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bg_image_intro),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_aspen),
                contentDescription = null, modifier = Modifier
                    .size(200.dp)
                    .padding(top = 56.dp)
            )

            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 32.dp)) {
                Text(
                    text = "Plan your",
                    fontSize = 24.sp,
                    fontFamily = MontserratFontFamily,
                    fontWeight = FontWeight.Normal,
                    color = Color.White
                )
                Text(
                    text = "Luxurious\nVacation",
                    style = TextStyle(
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Medium,
                        fontFamily = MontserratFontFamily,
                    ),
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(16.dp))

                TextButton(
                    onClick = {
                        navigateToDashboard()
                    }, colors = ButtonDefaults.textButtonColors(contentColor = Blue, containerColor = Blue),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Explore",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}