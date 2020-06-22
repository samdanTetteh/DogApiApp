package com.ijikod.dogapiapp.Model

import androidx.room.Entity


@Entity(tableName = "Breeds")
data class Breeds (
    val message: Map<String, List<String>>,
    val status: String
)