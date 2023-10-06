package data

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class SQLiteBaseCreator(context: Context) :
    SQLiteOpenHelper(context, DataBaseClass.DATABASE_NAME, null, DataBaseClass.DATABASE_VERSION),
    BaseColumns {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(DataBaseClass.CREATED_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}