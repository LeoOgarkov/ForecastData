package com.example.forecastdata


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    val jsonAssetsParser = JsonAssetsParser(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jsonAssetsParser.assetsToString(this, "city.list.json")
        jsonAssetsParser.parseAssetsJsonLonLatToSQLBase()
        val featureVetka = "FeatureVetka"
        Log.i("MyLog", featureVetka)
        val buildVetka = "BuildVetka"
        Log.i("MyLog", buildVetka)

    }
}