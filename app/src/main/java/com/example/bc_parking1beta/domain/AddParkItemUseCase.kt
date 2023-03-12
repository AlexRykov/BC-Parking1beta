package com.example.bc_parking1beta.domain

class AddParkItemUseCase(private val parkRepository: ParkRepository) {

    suspend fun addParkItem(parkItem: ParkItem) {
        parkRepository.addParkItem(parkItem)
    }
}
