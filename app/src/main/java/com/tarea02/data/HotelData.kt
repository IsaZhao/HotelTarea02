package com.tarea02.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.tarea02.model.Hotel
import kotlinx.coroutines.selects.select

@Dao
interface HotelData {
    @Query("select * from HOTEL")
    fun getAllData() : LiveData<List<Hotel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addHotel(hotel: Hotel)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateHotel(hotel: Hotel)

    @Delete
    suspend fun deleteHotel(hotel: Hotel)
}