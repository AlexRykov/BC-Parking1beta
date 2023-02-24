package com.example.bc_parking1beta.domain

data class ParkItem(
    val name: String,
    val firm: String,
    val dateFrom: String,
    val dateTo: String,
    val about: String,
    var enabled: Boolean,
    var id: Int = UNDEFINED_ID
) {

    companion object {

        const val UNDEFINED_ID = 0
    }
}