package com.tarea02.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.tarea02.data.HotelData
import com.tarea02.data.HotelDataBase
import com.tarea02.model.Hotel
import com.tarea02.repository.HotelRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HotelViewModel(application: Application) : AndroidViewModel(application){

    val getAllData : LiveData<List<Hotel>>
    private val repository: HotelRepository

    init {
        val hotelData = HotelDataBase.getDatabase(application).hotelData()
        repository = HotelRepository(hotelData)
        getAllData = repository.getAllData
    }


    fun addHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){repository.addHotel(hotel)}
    }


    fun updateHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){repository.updateHotel(hotel)}
    }


    fun deleteHotel(hotel: Hotel){
        viewModelScope.launch(Dispatchers.IO){repository.deleteHotel(hotel)}
    }
}