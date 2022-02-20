package com.tarea02.data


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tarea02.model.Hotel

@Database(entities = [Hotel::class], version = 1, exportSchema = false)
abstract class HotelDataBase : RoomDatabase(){
    abstract fun hotelData() : HotelData

    companion object{

        @Volatile
        private var INSTANCE: HotelDataBase? = null

        fun getDatabase(context: android.content.Context) : HotelDataBase {
            var instance = INSTANCE
            if (instance != null){
                return instance
            }
            synchronized(this){
                val basedatos = Room.databaseBuilder(
                    context.applicationContext,
                    HotelDataBase::class.java,
                    "hotel_database"
                ).build()
                INSTANCE = basedatos
                return basedatos
            }
        }
    }
}