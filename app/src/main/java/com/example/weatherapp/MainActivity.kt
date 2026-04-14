package com.example.sem4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.ui.text.style.TextAlign



@Preview
@Composable
fun MainScreen() {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF72EAFF),
            Color(0xFF72C2FF),
            Color(0xFF003888)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
            .padding(top=150.dp)
            .padding(bottom=150.dp)
            .padding(start=20.dp)
            .padding(end=20.dp)

    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "El Salvador",
                color = Color.White,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold

            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "25°C",
                color = Color.White,
                fontSize = 75.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "🧭",
                fontSize = 70.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White.copy(alpha = 0.2f),
                        shape = RoundedCornerShape(16.dp))
                    .padding(vertical = 20.dp, horizontal = 16.dp),

                ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Info(title = "HUM", value = "65%")
                    Spacer(modifier = Modifier.size(40.dp))
                    Info(title = "VIENTO", value = "12 km/h")
                    Spacer(modifier = Modifier.size(40.dp))
                    Info(title = "LLUVIA", value = "10%")
                }

            }
            Button(onClick = {},
                modifier = Modifier
                    .padding(top = 50.dp)
                    .padding(horizontal = 16.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Blue)
            ) {
                Text(text = "Actualizar",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold)
            }
        }
    }
}

@Composable
fun Info (title: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(title,
            color = Color.White.copy(alpha = 0.7f),
            fontSize = 20.sp,
        )
        Text(
            value,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}
