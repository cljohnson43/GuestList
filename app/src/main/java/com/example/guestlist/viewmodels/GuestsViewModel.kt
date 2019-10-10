package com.example.guestlist.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.guestlist.data.Guest
import com.example.guestlist.data.GuestsRepo

class GuestsViewModel(context: Context) : ViewModel() {
    var guests: MutableList<Guest> = mutableListOf()
    val guestList: MutableLiveData<List<Guest>> = MutableLiveData()
    val guestsRepo: GuestsRepo = GuestsRepo(context)

    init {
        loadGuests()
        guestList.value = guests
    }

    fun loadGuests() {
        guests = guestsRepo.allGuests() as MutableList<Guest>
    }

}