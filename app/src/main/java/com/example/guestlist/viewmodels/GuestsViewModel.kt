package com.example.guestlist.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.guestlist.data.Guest
import com.example.guestlist.data.GuestsRepo
import com.example.guestlist.utils.Logger

class GuestsViewModel(application: Application) : AndroidViewModel(application) {
    private var guests: MutableList<Guest> = mutableListOf()
    private val guestsRepo: GuestsRepo = GuestsRepo(application.applicationContext)

    init {
        loadGuests()
    }

    private fun loadGuests() {
        guestsRepo.insertGuest(
            Guest(name = "CJ", relation = "friend")
        )
        guestsRepo.insertGuest(
            Guest(name = "Matt Zook", relation = "friend")
        )
        guestsRepo.insertGuest(
            Guest(name = "Collin Orcutt", relation = "friend")
        )
        guestsRepo.insertGuest(
            Guest(name = "Milad Ossooli", relation = "friend")
        )
        guests = guestsRepo.allGuests() as MutableList<Guest>
    }

    fun getGuests(): List<Guest> = guestsRepo.allGuests()

    fun insertGuest(guest: Guest) {
        guestsRepo.insertGuest(guest)?.let {
            if (it > 0) {
                guest.id = it

                Logger.log("Guest $guest added to database!!!")

                guests.add(guest)
            }
        }
    }

    fun deleteGuests(vararg guests: Guest): Int = guestsRepo.deleteGuests(*guests)
}