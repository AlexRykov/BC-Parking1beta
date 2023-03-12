package com.example.bc_parking1beta.domain

class DeleteParkItemUseCase(private val parkRepository: ParkRepository) {

    suspend fun deleteShopItem(parkItem: ParkItem) {
        parkRepository.deleteParkItem(parkItem)
    }
}
