package com.example.bc_parking1beta.domain

data class ParkItem(
    val name: String,
    val firm: String,
    val dateFrom: String,
    val dateTo: String,
    val count: String,
    var id: Int = UNDEFINED_ID
) {

    companion object {

        const val UNDEFINED_ID = -1
    }
}