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
import androidx.compose.ui.Modifier

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.ui.theme.WeatherAppTheme


@Composable
 fun WeatherDisplay(list: ArrayList<String>) {


    Column(modifier = Modifier.padding(all = 8.dp).background(color = MaterialTheme.colors.background)) {

        Box(modifier = Modifier.background(color = MaterialTheme.colors.primaryVariant, shape = RoundedCornerShape(15))
                .padding(start = 20.dp, top = 10.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth()
                .requiredHeight(150.dp)
        ) {


            Row {
                Column {
                    Text(text = list[0][0].toString(), color = MaterialTheme.colors.surface, fontSize = 20.sp)

                    Spacer(modifier = Modifier.height(4.dp))

                    Image(painter = painterResource(list[0][1].toInt()), contentDescription = "weather pictures ", modifier = Modifier.size(120.dp))
                }

                Spacer(modifier = Modifier.width(50.dp))


                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
                    Text(text = list[0][3].toString(), fontSize = 50.sp, color = MaterialTheme.colors.surface)

                    Text(text = list[0][4].toString(), fontSize = 50.sp, color = MaterialTheme.colors.surface)
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (i in 1..7) {
                Row(Modifier.padding(bottom = 30.dp)) {

                    Text(
                        text = list[i][0].toString(),
                        Modifier.weight(1f),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Image(
                        painter = painterResource(list[i][1].toInt()),
                        contentDescription = "weather pictures ",
                        Modifier.weight(1f)
                    )
                    Text(text = list[i][2].toString(), Modifier.weight(1f), fontSize = 20.sp)
                    Text(text = list[i][3].toString(), Modifier.weight(1f), fontSize = 20.sp)
                }
            }
        }
    }
}




//@Preview
//@Composable
//fun weatherDisplayPreview() {
//    WeatherAppTheme {
//        WeatherDisplay(list = arrayListOf("aa", "ii"))
//    }
//}


