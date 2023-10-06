package data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase


class DbManager(val context: Context) {
    val sqLiteBaseCreator = SQLiteBaseCreator(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        db = sqLiteBaseCreator.writableDatabase
    }

    fun insertToDb(
        village: String,
        town: String,
        city: String,
        county: String,
        state: String,
        country: String,
        lon: String,
        lat: String,
        loaderMark: String
    ) {
        val values = ContentValues().apply {
            put(DataBaseClass.KEY_VILLAGE, village)
            put(DataBaseClass.KEY_TOWN, town)
            put(DataBaseClass.KEY_CITY, city)
            put(DataBaseClass.KEY_COUNTY, county)
            put(DataBaseClass.KEY_STATE, state)
            put(DataBaseClass.KEY_COUNTRY, country)
            put(DataBaseClass.KEY_LON, lon)
            put(DataBaseClass.KEY_LAT, lat)
            put(DataBaseClass.KEY_LOADPROCESSMARK, loaderMark)
        }
        db?.insert(DataBaseClass.TABLE_NAME_CITYINFO, null, values)
    }

    fun closeDb() {
        sqLiteBaseCreator.close()
    }
}
