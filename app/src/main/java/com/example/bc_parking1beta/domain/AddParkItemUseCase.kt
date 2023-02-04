package com.example.bc_parking1beta.domain

class AddParkItemUseCase(private val parkRepository: ParkRepository) {

    fun addParkItem(parkItem: ParkItem) {
        parkRepository.addParkItem(parkItem)
    }
}
