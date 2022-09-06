package com.example.weatherapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


@Composable
fun WeatherDisplay() {

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

            Row {
                Column {
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

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                Modifier.padding(bottom = 30.dp)
            ) {
                Text(text = "日にち", Modifier.weight(1f), fontSize = 20.sp, fontWeight = FontWeight.Bold )
                Image(painter = painterResource(R.drawable.hitu), contentDescription = "weather pictures ", Modifier.weight(1f))
                Text(text = "18/11", Modifier.weight(1f), fontSize = 20.sp)
                Text(text = "30%", Modifier.weight(1f), fontSize = 20.sp)
            }


            Row(
                Modifier.padding(bottom = 30.dp)
            ) {
                Text(text = "日にち", Modifier.weight(1f), fontSize = 20.sp, fontWeight = FontWeight.Bold )
                Image(painter = painterResource(R.drawable.hitu), contentDescription = "weather pictures ", Modifier.weight(1f))
                Text(text = "18/11", Modifier.weight(1f), fontSize = 20.sp)
                Text(text = "30%", Modifier.weight(1f), fontSize = 20.sp)
            }



            Row(
                Modifier.padding(bottom = 30.dp)
            ) {
                Text(text = "日にち", Modifier.weight(1f), fontSize = 20.sp,fontWeight = FontWeight.Bold  )
                Image(painter = painterResource(R.drawable.hitu), contentDescription = "weather pictures ", Modifier.weight(1f))
                Text(text = "18/11", Modifier.weight(1f), fontSize = 20.sp)
                Text(text = "30%", Modifier.weight(1f), fontSize = 20.sp)
            }



            Row(
                Modifier.padding(bottom = 30.dp)
            ) {
                Text(text = "日にち", Modifier.weight(1f), fontSize = 20.sp, fontWeight = FontWeight.Bold )
                Image(painter = painterResource(R.drawable.hitu), contentDescription = "weather pictures ", Modifier.weight(1f))
                Text(text = "18/11", Modifier.weight(1f), fontSize = 20.sp)
                Text(text = "30%", Modifier.weight(1f), fontSize = 20.sp)
            }


        }
    }
}


@Preview
@Composable
fun weatherDisplayPreview() {
    WeatherAppTheme {
        WeatherDisplay()
    }
}