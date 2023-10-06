package com.example.forecastdata

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import data.DbManager
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.json.JSONArray

class JsonAssetsParser(val context: Context) {
    var resultString: String = ""
    val dbManager = DbManager(context)
    val scope = CoroutineScope(CoroutineName("MyScope"))

    fun assetsToString(context: Context, fileName: String): String? {
        val inputStream = context.assets.open(fileName)
        var byteArray = byteArrayOf()
        byteArray = inputStream.readBytes()
        inputStream.close()
        resultString = byteArray.toString(Charsets.UTF_8)
        return resultString
    }


    @SuppressLint("SuspiciousIndentation")
    fun parseAssetsJsonLonLatToSQLBase() {
        var lon: String
        var lat: String
        val jsonArray = JSONArray(resultString)

        //dbManager.openDb()
        scope.launch {
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val jsonObject2 = jsonObject.getJSONObject("coord")
                lon = jsonObject2.getString("lon")
                lat = jsonObject2.getString("lat")
                val forecastApi = ForecastApi.create()
                delay(1500)
                try {
                    val api = forecastApi.getForecastJson(lon, lat)
                    Log.d("MYTAG", "QQQQ! = $api")
                    Log.d("MYTAG", api.address.city)

                } catch (error: Throwable) {
                    // Net Error
                }
            }


            /*val jsonObjectCityInfo=JSONObject(forecastData)
            val jsonObjectAdressInfo=jsonObjectCityInfo.getJSONObject("address")
            dbManager.insertToDb(jsonObjectAdressInfo.getString("village"), jsonObjectAdressInfo.getString("town"), jsonObjectAdressInfo.getString("city"),
                jsonObjectAdressInfo.getString("county"), jsonObjectAdressInfo.getString("state"), jsonObjectAdressInfo.getString("country"),lon, lat, "0")*/

        }
        //dbManager.closeDb()
    }
}



