package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun weatherDisplay() {

    Column(
        modifier = Modifier
            .padding(all = 8.dp)
            .background(color = MaterialTheme.colors.background)
    ) {

        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colors.primaryVariant,
                    shape = RoundedCornerShape(15)
                )
                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth()
                .requiredHeight(150.dp)

        ) {

            Row() {
                Column() {
                    Text(
                        text = "日にち",
                        color = MaterialTheme.colors.surface,
                        fontSize = 30.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Image(
                        painter = painterResource(R.drawable.hitu),
                        contentDescription = "weather pictures ",
                        modifier = Modifier.size(120.dp)
                    )
                }

                Spacer(modifier = Modifier.width(50.dp))


                Column(

                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center

                ) {
                    Text(
                        text = "20/11",
                        fontSize = 50.sp,
                        color = MaterialTheme.colors.surface
                    )

                    Text(
                        text = "50%",
                        fontSize = 50.sp,
                        color = MaterialTheme.colors.surface
                    )

                }
            }
        }

    }

    Row() {
        
    }
    
}