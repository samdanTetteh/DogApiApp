package com.ijikod.dogapiapp.Data.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ijikod.dogapiapp.Data.DataConverter
import com.ijikod.dogapiapp.Model.Breeds

@Database(entities = [Breeds::class], version = 1, exportSchema = false)
@TypeConverters(DataConverter::class)
abstract class DogDataBase : RoomDatabase() {



    companion object{
        @Volatile
        private var INSTANCE: DogDataBase? = null

        fun getDatabase(context: Context) : DogDataBase{
            if (INSTANCE == null){
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context.applicationContext, DogDataBase::class.java, "dogs.db").build()
                }
            }

            return INSTANCE!!
        }

    }


}