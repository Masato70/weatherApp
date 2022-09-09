package com.example.weatherapp

import androidx.compose.runtime.Composable
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL


@Composable
fun getJson(): String {

    var weatherdata = ""

    val apiKey = ""
    var apiUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=35.68&lon=139.70&appid=${apiKey}&exclude=current,minutely,hourly,alerts"
    var url = URL(apiUrl)
    var br = BufferedReader(InputStreamReader(url.openStream()))
    var str = br.readText()
    var json = JSONObject(str)
    val weatherAry = json.getJSONArray("daily")

    var list :ArrayList<String> = arrayListOf()


    for (i in 0..7) {
        var weatherObj = weatherAry.getJSONObject(i)
        var temp = weatherObj.getJSONObject("temp")
        var weather = weatherObj.getJSONArray("weather")
        var weatherToObj = weather.getJSONObject(0)

        var date = weatherObj.get("dt")
        var icon = weatherToObj.get("icon")
        var pop = weatherObj.get("pop")
        var min = temp.get("min")
        var max = temp.get("max")

        list += (arrayListOf(date, icon, pop, min,max).toString())
    }
    weatherdata = list.toString()
    return weatherdata
}







