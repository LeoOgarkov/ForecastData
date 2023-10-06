package data

import  android.provider.BaseColumns

object DataBaseClass {

    const val DATABASE_VERSION: Int = 1;
    const val DATABASE_NAME: String = "ForecastCities.db"
    const val TABLE_NAME_CITYINFO: String = "LocationData"
    const val KEY_VILLAGE: String = "village"
    const val KEY_TOWN: String = "town"
    const val KEY_CITY: String = "city"
    const val KEY_COUNTY: String = "county"
    const val KEY_STATE: String = "state"
    const val KEY_COUNTRY: String = "country"
    const val KEY_LON: String = "lon"
    const val KEY_LAT: String = "lat"
    const val KEY_LOADPROCESSMARK: String = "mark"

    const val CREATED_TABLE =
        "CREATE TABLE $TABLE_NAME_CITYINFO (${BaseColumns._ID} INTEGER PRIMARY KEY, $KEY_VILLAGE text,$KEY_TOWN text,$KEY_CITY text,$KEY_COUNTY text,$KEY_STATE text,$KEY_COUNTRY text,$KEY_LON text,$KEY_LAT text,$KEY_LOADPROCESSMARK text)"


}