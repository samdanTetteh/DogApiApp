package com.ijikod.dogapiapp.Data.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ijikod.dogapiapp.Model.Breeds

@Dao
interface  Dao {

    @Query("Select * FROM Breeds")
    fun getBreeds() : LiveData<Breeds>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBreeds(breeds: Breeds)
}