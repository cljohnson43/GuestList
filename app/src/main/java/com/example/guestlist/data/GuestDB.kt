package com.example.guestlist.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Guest::class), version = 1)
abstract class GuestDB : RoomDatabase() {
    abstract fun guestDAO(): GuestDAO
}