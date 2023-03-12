package com.example.bc_parking1beta.domain

class EditParkItemUseCase(private val parkRepository: ParkRepository) {

    suspend fun editParkItem(parkItem: ParkItem) {
        parkRepository.editParkItem(parkItem)
    }
}
