package com.example.bc_parking1beta.domain

class GetParkItemUseCase(private val parkRepository: ParkRepository) {

    suspend fun getParkItem(parkItemId: Int): ParkItem {

        return parkRepository.getParkItem(parkItemId)
    }
}
