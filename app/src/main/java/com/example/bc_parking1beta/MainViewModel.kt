package com.example.bc_parking1beta

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bc_parking1beta.data.ParkRepositoryImpl
import com.example.bc_parking1beta.domain.*

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ParkRepositoryImpl(application)

    private val getParkListUseCase = GetParkListUseCase(repository)
    private val deleteParkItemUseCase = DeleteParkItemUseCase(repository)
    private val editParkItemUseCase = EditParkItemUseCase(repository)

    val parkList = getParkListUseCase.getParkList()

    fun deleteParkItem(parkItem: ParkItem) {
        deleteParkItemUseCase.deleteShopItem(parkItem)
    }

    fun changeEnableState(parkItem: ParkItem) {
        val newItem = parkItem.copy(enabled = !parkItem.enabled)
        editParkItemUseCase.editParkItem(newItem)
    }
}