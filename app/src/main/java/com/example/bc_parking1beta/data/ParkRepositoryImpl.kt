package com.example.bc_parking1beta.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.domain.ParkRepository
import kotlin.random.Random

class ParkRepositoryImpl(application: Application) : ParkRepository {

    private val parkListDao = AppDataBase.getInstance(application).parkListDao()
    private val mapper = ParkListMapper()

//    private val parkListLD = MutableLiveData<List<ParkItem>>()
//
//    private val parkList = sortedSetOf<ParkItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
////    This TreeSet for sorting list.
////    We compare 1st element with 2nd, to edited element don't fall in the end of list
////    before it was ->
////    private val parkList = mutableListOf<ParkItem>()
//
//    private var autoIncrementId = 0
//
//    init {
//        for (i in 0 until 13) {
//            val item = ParkItem(
//                "Name $i",
//                "firm $i",
//                "date_from",
//                "date_to",
//                about = "$i",
//                enabled = Random.nextBoolean()
//            )
//            addParkItem(item)
//        }
//    }

    override fun editParkItem(parkItem: ParkItem) {
        parkListDao.addParkItem(mapper.mapEntityToDbModel(parkItem))
//        val oldElement = getParkItem(parkItem.id)
//        parkList.remove(oldElement)
//        addParkItem(parkItem)
    }

    override fun addParkItem(parkItem: ParkItem) {
        parkListDao.addParkItem(mapper.mapEntityToDbModel(parkItem))
//        if (parkItem.id == ParkItem.UNDEFINED_ID) {
//            parkItem.id = autoIncrementId++
//        }
//        parkList.add(parkItem)
//        updateList()
    }

    override fun getParkItem(parkItemId: Int): ParkItem {
        val dbModel = parkListDao.getParkItem(parkItemId)
        return mapper.mapDbModelToEntity(dbModel)
//        return parkList.find {
//            it.id == parkItemId
//        } ?: throw RuntimeException("Element with id $parkItemId not found")
    }

    override fun deleteParkItem(parkItem: ParkItem) {
        parkListDao.deleteParkItem(parkItem.id)
//        parkList.remove(parkItem)
//        updateList()
    }

    override fun getParkList(): LiveData<List<ParkItem>> {
//        3
        return Transformations.map(parkListDao.getParkList()){
            mapper.mapListDbModelToListEntity(it)
        }
//        2
//        return  MediatorLiveData<List<ParkItem>>().apply {
//            addSource(parkListDao.getParkList()){
//                value = mapper.mapListDbModelToListEntity(it)
//            }
//        }
//        1
//        return parkListLD
    }

//    private fun updateList() {
//        parkListLD.value = parkList.toList()
//    }
}
