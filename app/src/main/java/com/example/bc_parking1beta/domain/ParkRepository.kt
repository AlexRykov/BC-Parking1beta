package com.example.bc_parking1beta.domain

import androidx.lifecycle.LiveData

interface ParkRepository {

    suspend fun editParkItem(parkItem: ParkItem)

    suspend fun addParkItem(parkItem: ParkItem)

    suspend fun deleteParkItem(parkItem: ParkItem)

    suspend fun getParkItem(parkItemId: Int): ParkItem

    fun getParkList(): LiveData<List<ParkItem>>
}