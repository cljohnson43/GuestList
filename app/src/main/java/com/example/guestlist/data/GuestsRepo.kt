package com.example.guestlist.data

import android.content.Context
import androidx.room.Room

class GuestsRepo(context: Context) {
    val db: GuestsDB by lazy {
        Room.databaseBuilder(
            context,
            GuestsDB::class.java,
            GuestsDB.DB_NAME
        )
            .allowMainThreadQueries().build()
    }

    fun allGuests(): List<Guest> = db.guestDAO().loadAllGuests() as List<Guest>
    fun insertGuest(guest: Guest): Long = db.guestDAO().insertGuest(guest)
    fun deleteGuest(guest: Guest): Int = db.guestDAO().deleteGuest(guest)
}