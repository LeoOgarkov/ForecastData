package com.example.forecastdata

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ForecastResponse(
    @SerialName("address")
    val address: Forecastaddress
)

@Serializable
data class Forecastaddress(
    @SerialName("village") val village: String = "1",
    @SerialName("town") val town: String = "1",
    @SerialName("city") val city: String = "1",
    @SerialName("county") val county: String = "1",
    @SerialName("state") val state: String = "1",
    @SerialName("country") val country: String = "1",
)


//{
//    "place_id": 219264834,
//    "licence": "Data © OpenStreetMap contributors, ODbL 1.0. http://osm.org/copyright",
//    "osm_type": "way",
//    "osm_id": 545671340,
//    "lat": "32.999108",
//    "lon": "47.0002983",
//    "class": "highway",
//    "type": "tertiary",
//    "place_rank": 26,
//    "importance": 0.10000999999999993,
//    "addresstype": "road",
//    "name": "",
//    "display_name": "سر کمر, دهستان سیدابراهیم, بخش زرین آباد, شهرستان دهلران, Илам, Иран",
//    "address": {
//        "village": "سر کمر",
//        "city": "دهستان سیدابراهیم",
//        "district": "بخش زرین آباد",
//        "county": "شهرستان دهلران",
//        "state": "Илам",
//        "ISO3166-2-lvl4": "IR-16",
//        "country": "Иран",
//        "country_code": "ir"
//    },
//    "boundingbox": [
//        "32.9809218",
//        "33.0003423",
//        "46.9462182",
//        "47.0233691"
//    ]
//}


