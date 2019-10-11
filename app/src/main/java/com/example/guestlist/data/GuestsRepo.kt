package com.example.guestlist.data

import android.content.Context
import androidx.lifecycle.LiveData
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

    fun allGuests(): LiveData<List<Guest>> = db.guestDAO().loadAllGuests()
    fun insertGuest(guest: Guest): Long = db.guestDAO().insertGuest(guest)
    fun deleteGuests(vararg guest: Guest): Int = db.guestDAO().deleteGuests(*guest)
}