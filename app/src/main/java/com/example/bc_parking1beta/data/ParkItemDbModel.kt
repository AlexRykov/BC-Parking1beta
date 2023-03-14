package com.example.bc_parking1beta.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "park_items")
data class ParkItemDbModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "firm")
    val firm: String,
    @ColumnInfo(name = "dateFrom")
    val dateFrom: String,
    @ColumnInfo(name = "dateTo")
    val dateTo: String,
    @ColumnInfo(name = "about")
    val about: String,
    val enabled: Boolean
)