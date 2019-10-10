package com.example.guestlist.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Guest::class), version = 1)
abstract class GuestsDB : RoomDatabase() {
    abstract fun guestDAO(): GuestDAO

    companion object {
        const val DB_NAME = "guests.db"
    }
}