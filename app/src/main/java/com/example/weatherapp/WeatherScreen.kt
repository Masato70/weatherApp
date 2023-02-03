package com.example.weatherapp

import android.content.ClipData
import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.weatherapp.ui.theme.WeatherAppTheme


@Composable
fun WeatherDisplay(list: ArrayList<ArrayList<String>>) {

    var popRound = list[0][2].toDouble().times(100)
    val maxRound = list[0][4].toDouble().times(1)
    val minRound = list[0][3].toDouble().times(1)

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
                .padding(start = 5.dp, top = 5.dp, end = 50.dp, bottom = 5.dp)
                .fillMaxWidth()
                .requiredHeight(200.dp)
        ) {

            Row {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(list[0][1]),
                        contentDescription = "weather pictures ",
                        modifier = Modifier.size(200.dp).requiredSize(200.dp)

                    )
                }


                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    Text(
                        text = list[0][0] + "日",
                        color = MaterialTheme.colors.surface,
                        fontSize = 30.sp,
                    )

                    Text(
                        text = Math.round(maxRound).toString() + "/" + Math.round(minRound)
                            .toString(), fontSize = 60.sp, color = MaterialTheme.colors.surface,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = Math.round(popRound).toString() + "%",
                        fontSize = 30.sp,
                        color = MaterialTheme.colors.surface,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (i in 1..7) {
                Row(
                    Modifier.padding(bottom = 30.dp, start = 20.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    val popRoundlist = list[i][2].toDouble().times(100)
                    val maxRoundlist = list[i][4].toDouble().times(1)
                    val minRoundlist = list[i][3].toDouble().times(1)

                    Text(
                        text = list[i][0] + "日",
                        Modifier.weight(1f)
                    )

                    Image(
                        painter = rememberAsyncImagePainter(list[i][1]),
                        contentDescription = "weather pictures ",
                        Modifier
                            .weight(1f)
                            .size(50.dp)
                            .requiredSize(100.dp)
                    )
                    Text(
                        text = Math.round(popRoundlist).toString() + "%",
                        Modifier.weight(1f),
                        fontSize = 20.sp
                    )
                    Text(
                        text = Math.round(maxRoundlist).toString() + "/" + Math.round(minRoundlist)
                            .toString(), Modifier.weight(1f), fontSize = 20.sp
                    )
                }
            }
        }
    }
}