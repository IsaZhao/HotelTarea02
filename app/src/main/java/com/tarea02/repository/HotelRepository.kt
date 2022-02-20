package com.tarea02.repository

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.tarea02.data.HotelData
import com.tarea02.model.Hotel

class HotelRepository(private val hotelData: HotelData){
    val getAllData : LiveData<List<Hotel>> = hotelData.getAllData()


    suspend fun addHotel(hotel : Hotel){
        hotelData.addHotel(hotel)
    }


    suspend fun updateHotel(hotel : Hotel){
        hotelData.updateHotel(hotel)
    }


    suspend fun deleteHotel(hotel : Hotel){
        hotelData.deleteHotel(hotel)
    }
}