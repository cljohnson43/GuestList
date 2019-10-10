package com.example.guestlist.data

import android.content.Context
import androidx.room.Room

class GuestsRepo(context: Context) {
    val db: GuestsDB by lazy {
        Room.databaseBuilder(
            context,
            GuestsDB::class.java,
            GuestsDB.DB_NAME
        ).build()
    }

    fun allGuests(): List<Guest> = db.guestDAO().loadAllGuests() as List<Guest>
    fun insertGuests(vararg guest: Guest): List<Long> = db.guestDAO().insertGuests()
    fun deleteGuests(vararg guest: Guest): Int = db.guestDAO().deleteGuests()
}