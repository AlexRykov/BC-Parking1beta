package com.example.bc_parking1beta.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.bc_parking1beta.domain.ParkItem

@Entity(tableName = "park_items")
data class ParkItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val firm: String,
    val dateFrom: String,
    val dateTo: String,
    val about: String,
    val enabled: Boolean
)