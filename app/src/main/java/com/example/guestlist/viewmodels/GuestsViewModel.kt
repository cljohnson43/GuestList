package com.example.guestlist.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.guestlist.data.Guest
import com.example.guestlist.data.GuestsRepo

class GuestsViewModel(application: Application) : AndroidViewModel(application) {
    private val guestsRepo: GuestsRepo = GuestsRepo(application.applicationContext)

    fun getGuests(): LiveData<List<Guest>> = guestsRepo.allGuests()

    fun insertGuest(guest: Guest): Long = guestsRepo.insertGuest(guest)
    fun deleteGuests(vararg guests: Guest): Int = guestsRepo.deleteGuests(*guests)
}