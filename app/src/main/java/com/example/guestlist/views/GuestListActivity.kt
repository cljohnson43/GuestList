package com.example.guestlist.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.guestlist.R
import com.example.guestlist.data.Guest
import com.example.guestlist.utils.Logger
import com.example.guestlist.viewmodels.GuestsViewModel

class GuestListActivity : AppCompatActivity() {

    val guestsViewModel: GuestsViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(GuestsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_list)

        guestsViewModel.getGuests().forEach {
            Logger.log(it.toString())
        }
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btn_add_guest -> guestsViewModel.insertGuest(Guest(name = "Steve Johnson", relation = "Family"))
            R.id.btn_delete_guests -> guestsViewModel.deleteGuests(*guestsViewModel.getGuests().toTypedArray())
        }
    }
}
