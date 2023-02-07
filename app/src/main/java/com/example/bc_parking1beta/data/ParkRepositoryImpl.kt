package com.example.bc_parking1beta.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.domain.ParkRepository
import kotlin.random.Random

object ParkRepositoryImpl : ParkRepository {

    private val parkListLD = MutableLiveData<List<ParkItem>>()

    private val parkList = sortedSetOf<ParkItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
//    This TreeSet for sorting list.
//    We compare 1st element with 2nd, to edited element don't fall in the end of list
//    before it was ->
//    private val parkList = mutableListOf<ParkItem>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 20) {
            val item = ParkItem(
                "Name $i",
                "firm $i",
                "date_from",
                "date_to",
                count = "$i",
                enabled = Random.nextBoolean()
            )
            addParkItem(item)
        }
    }

    override fun editParkItem(parkItem: ParkItem) {
        val oldElement = getParkItem(parkItem.id)
        parkList.remove(oldElement)
        addParkItem(parkItem)
    }

    override fun addParkItem(parkItem: ParkItem) {
        if (parkItem.id == ParkItem.UNDEFINED_ID) {
            parkItem.id = autoIncrementId++
        }
        parkList.add(parkItem)
        updateList()
    }

    override fun getParkItem(parkItemId: Int): ParkItem {
        return parkList.find {
            it.id == parkItemId
        } ?: throw RuntimeException("Element with id $parkItemId not found")
    }

    override fun getParkList(): LiveData<List<ParkItem>> {
        return parkListLD
    }

    override fun deleteParkItem(parkItem: ParkItem) {
        parkList.remove(parkItem)
        updateList()
    }

    private fun updateList() {
        parkListLD.value = parkList.toList()
    }
}
