package com.example.bc_parking1beta.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ParkListDao {

    @Query("SELECT * FROM park_items")
    fun getParkList(): LiveData<List<ParkItemDbModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addParkItem(parkItemDbModel: ParkItemDbModel)

    @Query("DELETE FROM park_items WHERE id=:parkItemId")
    fun deleteParkItem(parkItemId: Int)

    @Query("SELECT * FROM park_items WHERE id=:parkItemId LIMIT 1")
    fun getParkItem(parkItemId: Int): ParkItemDbModel
}
