package com.example.bc_parking1beta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.data.ParkRepositoryImpl
import com.example.bc_parking1beta.domain.AddParkItemUseCase
import com.example.bc_parking1beta.domain.EditParkItemUseCase
import com.example.bc_parking1beta.domain.GetParkItemUseCase

class ParkItemViewModel : ViewModel(){
    private val repository = ParkRepositoryImpl

    private val getParkItemUseCase = GetParkItemUseCase(repository)
    private val addParkItemUseCase = AddParkItemUseCase(repository)
    private val editParkItemUseCase = EditParkItemUseCase(repository)

    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputFirm = MutableLiveData<Boolean>()
    val errorInputFirm: LiveData<Boolean>
        get() = _errorInputFirm

    private val _errorInputDateFrom = MutableLiveData<Boolean>()
    val errorInputDateFrom: LiveData<Boolean>
        get() = _errorInputDateFrom

    private val _errorInputDateTo = MutableLiveData<Boolean>()
    val errorInputDateTo: LiveData<Boolean>
        get() = _errorInputDateTo

    private val _errorInputAbout = MutableLiveData<Boolean>()
    val errorInputAbout: LiveData<Boolean>
        get() = _errorInputAbout

    private val _parkItem = MutableLiveData<ParkItem>()
    val parkItem: LiveData<ParkItem>
        get() = _parkItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getParkItem(parkItemId: Int) {
        val item = getParkItemUseCase.getParkItem(parkItemId)
        _parkItem.value = item
    }

    fun addParkItem(
        inputName: String?,
        inputFirm: String?,
        inputDateFrom: String?,
        inputDateTo: String?,
        inputAbout: String?,
        enabled: Boolean

    ) {
        val name = parseName(inputName)
        val firm = parseName(inputFirm)
        val dateFrom = parseName(inputDateFrom)
        val dateTo = parseName(inputDateTo)
        val about = parseName(inputAbout)

        val fieldsValid = validateInput(name, firm, dateFrom, dateTo, about)
        if (fieldsValid) {
            val parkItem = ParkItem(name, firm, dateFrom, dateTo, about, enabled)
            addParkItemUseCase.addParkItem(parkItem)
            finishWork()
        }
    }

    fun editParkItem(
        inputName: String?,
        inputFirm: String?,
        inputDateFrom: String?,
        inputDateTo: String?,
        inputAbout: String?
    ) {
        val name = parseName(inputName)
        val firm = parseName(inputFirm)
        val dateFrom = parseName(inputDateFrom)
        val dateTo = parseName(inputDateTo)
        val about = parseName(inputAbout)

        val fieldsValid = validateInput(name, firm, dateFrom, dateTo, about)
        if (fieldsValid) {
            _parkItem.value?.let {
                val item = it.copy(
                    name = name,
                    firm = firm,
                    dateFrom = dateFrom,
                    dateTo = dateTo,
                    about = about
                )
                editParkItemUseCase.editParkItem(item)
                finishWork()
            }
        }
    }

    private fun parseName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

//    private fun parseCount(inputCount: String?): Int {
//        return try {
//            inputCount?.trim()?.toInt() ?: 0
//        } catch (e: Exception) {
//            0
//        }
//    }

    private fun validateInput(
        name: String,
        firm: String,
        dateFrom: String,
        dateTo: String,
        about: String
    ): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (firm.isBlank()) {
            _errorInputFirm.value = true
            result = false
        }
        if (dateFrom.isBlank()) {
            _errorInputDateFrom.value = true
            result = false
        }
        if (dateTo.isBlank()) {
            _errorInputDateTo.value = true
            result = false
        }
        if (about.isBlank()) {
            _errorInputAbout.value = true
            result = false
        }
        return result
    }

    fun resetErrorInputName() {
        _errorInputName.value = false
    }

    fun resetErrorInputFirm() {
        _errorInputFirm.value = false
    }

    fun resetErrorInputDateFrom() {
        _errorInputDateFrom.value = false
    }

    fun resetErrorInputDateTo() {
        _errorInputDateTo.value = false
    }

    fun resetErrorInputCount() {
        _errorInputAbout.value = false
    }

    private fun finishWork() {
        _shouldCloseScreen.value = Unit
    }
}