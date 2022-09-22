package com.example.weatherapp

import android.content.ContentValues.TAG
import android.util.Log
import kotlinx.coroutines.*
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

import java.net.URL
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


fun weatherTask(): ArrayList<String>? {

    var lista: ArrayList<String>? = null

    val apiKey = ""
    val apiUrl = "https://api.openweathermap.org/data/2.5/onecall?lat=35.68&lon=139.70&appid=${apiKey}&exclude=current,minutely,hourly,alerts"

    GlobalScope.launch {
        withContext(Dispatchers.IO) {
            val result = weatherBackgroundTast(apiUrl)
            lista = weatherJsonTask(result)
        }
    }


    Log.d(TAG, lista.toString())
    return lista
}


fun weatherBackgroundTast(apiUrl: String): String {
    Log.d(TAG, "通過2")

    var weatherdata = ""

    try {
        val url = URL(apiUrl)
        val br = BufferedReader(InputStreamReader(url.openStream()))
        weatherdata = br.readText()

    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: JSONException) {
        e.printStackTrace()
    }
    return weatherdata
}


fun unixTimeChange(unixTime: String): String {
    Log.d(TAG, "通過4")

    var sdf = SimpleDateFormat("dd")
    var nowTime = Date(unixTime.toInt() * 1000L)
    return sdf.format(nowTime)
}


fun weatherJsonTask(result: String): ArrayList<String> {
    Log.d(TAG, "通過3")


    //取得した情報をしまう
    var list: ArrayList<String> = arrayListOf()


    val json = JSONObject(result)
    val weatherAry = json.getJSONArray("daily")


    for (i in 0..7) {
        val weatherObj = weatherAry.getJSONObject(i)
        var temp = weatherObj.getJSONObject("temp")
        var weather = weatherObj.getJSONArray("weather")
        var weatherToObj = weather.getJSONObject(0)

        var date = weatherObj.get("dt")
        var iconnumber = weatherToObj.get("icon")
        var pop = weatherObj.get("pop")
        var min = temp.get("min")
        var max = temp.get("max")


        date = unixTimeChange(date.toString())
        var icon = "https://openweathermap.org/img/wn/${iconnumber}@2x.png"
        list += (arrayListOf(date, icon, pop, min, max).toString())
    }
    return list
}

