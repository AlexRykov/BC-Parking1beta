package com.example.bc_parking1beta.db

import android.provider.BaseColumns

object MyDBNameClass : BaseColumns {

    const val TABLE_NAME = "my_table"
    const val COLUMN_NAME_NAME = "name"
    const val COLUMN_NAME_FIRM = "firm"
    const val COLUMN_NAME_DATE_FROM = "date_from"
    const val COLUMN_NAME_DATE_TO = "date_to"
    const val COLUMN_NAME_ABOUT = "about"

    const val DATABASE_VERSION = 5
    const val DATABASE_NAME = "MyLessonDB2.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (${BaseColumns._ID} INTEGER PRIMARY KEY,$COLUMN_NAME_NAME TEXT,$COLUMN_NAME_FIRM TEXT,$COLUMN_NAME_DATE_FROM TEXT,$COLUMN_NAME_DATE_TO TEXT,$COLUMN_NAME_ABOUT TEXT)"

    const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS $TABLE_NAME"
}
