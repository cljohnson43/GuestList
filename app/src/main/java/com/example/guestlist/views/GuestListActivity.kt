package com.example.guestlist.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guestlist.R
import com.example.guestlist.adapters.GuestsAdapter
import com.example.guestlist.data.Guest
import com.example.guestlist.utils.Logger
import com.example.guestlist.viewmodels.GuestsViewModel
import kotlinx.android.synthetic.main.activity_guest_list.*

class GuestListActivity : AppCompatActivity() {

    val guestsViewModel: GuestsViewModel by lazy {
        ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application))
            .get(GuestsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_list)

        val guestList = guestsViewModel.getGuests()

        rv_guest_list.adapter = GuestsAdapter(guestList)
        rv_guest_list.layoutManager = LinearLayoutManager(this)
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btn_add_guest -> {
                val guest = Guest(
                    name = et_name.text.toString(),
                    relation = "friend"
                )
                guestsViewModel.insertGuest(guest)
                et_name.text.clear()
                rv_guest_list.adapter?.notifyDataSetChanged()
            }
        }
    }
}
