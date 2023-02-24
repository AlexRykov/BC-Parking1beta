package com.example.bc_parking1beta.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.bc_parking1beta.domain.ParkItem
import com.example.bc_parking1beta.domain.ParkRepository

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

//    init {
//        val a = listOf(
//            "1","2","3","4","5","6","7","8","9","10","11","12","13","14","14","15","15","16","17",
//            "18","19","20","21","22","23","24","25","26","27","28","29","30",
//            "31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47",
//            "48","49","50","51","52","53","54",
//            "101","102","111","115","114","103","104","110","109","113","112","108","107","106","105",
//            "221","219","220","217","218","215","216","214","213","201","202","222","223","211",
//            "212","203","204","205","206","207","208","209","210"
//        )
//        for (i in a) {
////            val item = ParkItem(
////                "Name $i",
////                "firm $i",
////                "date_from",
////                "date_to",
////                about = "$i",
////                enabled = Random.nextBoolean()
////            )
////            parkListDao.deleteParkItem(i)
//            parkListDao.addParkItem(
//                 parkItemDbModel = ParkItemDbModel(
//                     id = i.toInt(),
//                     "$i",
//                     "$i",
//                     "$i",
//                     "$i",
//                     "$i",
//                     false
//                 )
//            )
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
