package com.example.bc_parking1beta.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.bc_parking1beta.domain.ParkItem

class MyDbManager(context: Context) {

    private val myDbHelper = MyDbHelper(context)
    var db: SQLiteDatabase? = null

    fun openDb() {
        // Gets the data repository in write mode
        db = myDbHelper.writableDatabase
    }

    // Insert the new row, returning the primary key value of the new row
    fun insertToDb(
        name: String,
        firm: String,
        dateFrom: String,
        dateTo: String,
        about: String
    ) {
        // Create a new map of values, where column names are the keys
        val values = ContentValues().apply {
            put(MyDBNameClass.COLUMN_NAME_NAME, name)
            put(MyDBNameClass.COLUMN_NAME_FIRM, firm)
            put(MyDBNameClass.COLUMN_NAME_DATE_FROM, dateFrom)
            put(MyDBNameClass.COLUMN_NAME_DATE_TO, dateTo)
            put(MyDBNameClass.COLUMN_NAME_ABOUT, about)
        }
        db?.insert(MyDBNameClass.TABLE_NAME, null, values)
    }


    @SuppressLint("Range")
    fun readDbData(): ArrayList<ParkItem> {
        var dataList = ArrayList<ParkItem>()
        val cursor = db?.query(
            MyDBNameClass.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            null
        )

        while (cursor?.moveToNext()!!) {

            val dataName = cursor?.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_NAME))
            val dataFirm = cursor?.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_FIRM))
            val dataDateFrom =
                cursor?.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_DATE_FROM))
            val dataDateTo =
                cursor?.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_DATE_TO))
            val dataAbout = cursor?.getString(cursor.getColumnIndex(MyDBNameClass.COLUMN_NAME_ABOUT))
            var item = ParkItem(
                name = dataName?:"fd",
                        firm = dataFirm?:"firm",
                        dateFrom = dataDateFrom?:"date",
                        dateTo = dataDateTo?:"date",
                        about = dataAbout?:"abo",
                true
            )

            dataList.add(item)

        }
        cursor?.close()
        return dataList
    }

    fun closeDb() {
        myDbHelper.close()
    }
}

