package com.example.guestlist.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guestlist.R
import com.example.guestlist.data.Guest

class GuestsAdapter(val guestList: List<Guest>) :
    RecyclerView.Adapter<GuestsAdapter.GuestsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.guest_card, parent, false)
        return GuestsViewHolder(view)
    }

    override fun getItemCount(): Int = guestList.size

    override fun onBindViewHolder(holder: GuestsViewHolder, position: Int) {
        guestList.get(position).let {
            holder.tvName.text = it.name
            holder.tvRelation.text = it.relation
        }
    }

    class GuestsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tv_name_card)
        val tvRelation: TextView = itemView.findViewById(R.id.tv_relation_card)
    }
}