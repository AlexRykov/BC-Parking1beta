package com.example.bc_parking1beta.domain

class EditParkItemUseCase(private val parkRepository: ParkRepository) {

    fun editParkItem(parkItem: ParkItem) {
        parkRepository.editParkItem(parkItem)
    }
}
