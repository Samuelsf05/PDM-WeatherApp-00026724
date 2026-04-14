package com.example.sem4

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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

@Preview
@Composable
fun WeatherScreen() {
    val backgroundGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFFA0B5EB),
            Color(0xFFEA52F8),
            Color(0xFF0066FF)
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = backgroundGradient)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "El Salvador",
                    color = Color.White,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "25°C",
                    color = Color.White,
                    fontSize = 82.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Soleado",
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = 25.sp,
                )
            }

            Spacer(modifier = Modifier.height(35.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
            SectionLabel("PRONÓSTICO POR HORAS")
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    HourItem("Ahora", "☀️", "25°")
                    HourItem("14:00", "☀️", "26°")
                    HourItem("16:00", "⛅", "24°")
                    HourItem("18:00", "⛅", "22°")
                    HourItem("20:00", "🌙", "20°")
                }
            }

            Spacer(modifier = Modifier.height(35.dp))

            // Detalles
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    SectionLabel("DETALLES")

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        DetailItem("Humedad", "65%")
                        DetailItem("Viento", "12 km/h")
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        DetailItem("Presión", "1012 hPa")
                        DetailItem("UV", "5")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Pronóstico semanal
            SectionLabel("PRONÓSTICO SEMANAL")
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White.copy(alpha = 0.2f)
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    WeekDayItem("Lun", "☀️", "28°", "22°")
                    WeekDayItem("Mar", "⛅", "27°", "21°")
                    WeekDayItem("Mié", "🌧️", "26°", "20°")
                    WeekDayItem("Jue", "⛅", "25°", "19°")
                    WeekDayItem("Vie", "🌦️", "24°", "18°")
                }
            }
        }
    }
}

@Composable
fun SectionLabel(text: String) {
    Text(
        text = text,
        color = Color.White.copy(alpha = 0.7f),
        fontSize = 18.sp,
        modifier = Modifier.padding(bottom = 6.dp)
    )
}

@Composable
fun HourItem(hour: String, icon: String, temp: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = hour, color = Color.White.copy(alpha = 0.7f), fontSize = 16.sp)
        Text(text = icon, fontSize = 26.sp)
        Text(text = temp, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}

@Composable
fun DetailItem(label: String, value: String) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.6f),
            fontSize = 18.sp

        )
        Text(
            text = value,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun WeekDayItem(day: String, icon: String, high: String, low: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = day, color = Color.White, fontSize = 18.sp, modifier = Modifier.width(40.dp))
        Text(text = icon, fontSize = 30.sp)
        Text(
            text = "$high / $low",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
