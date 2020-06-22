package com.ijikod.dogapiapp.Data

import androidx.room.TypeConverter
import com.ijikod.dogapiapp.Model.Breeds
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.ParameterizedType

class DataConverter {

    private val moshi = Moshi.Builder().build()
    private val MapBreeds : ParameterizedType = Types.newParameterizedType(Map::class.java, Breeds::class.java)
    private val mapStringJsonAdapter: JsonAdapter<Map<String, List<String>>> = moshi.adapter(MapBreeds)



    @TypeConverter
    fun toStringMap(map: Map<String, List<String>>) : String{
        return mapStringJsonAdapter.toJson(map)
    }



    @TypeConverter
    fun toMapString(jsonStr: String?) : Map<String, List<String>>?{
        return jsonStr?.let { mapStringJsonAdapter.fromJson(jsonStr) }
    }
}
