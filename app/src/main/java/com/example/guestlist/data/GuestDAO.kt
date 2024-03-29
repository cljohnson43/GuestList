package com.example.guestlist.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GuestDAO {
    // TODO look into defining what constitutes a conflict
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertGuest(guest: Guest): Long

    @Delete
    fun deleteGuests(vararg guest: Guest): Int

    @Query("SELECT * FROM ${Guest.TABLE_NAME}")
    fun loadAllGuests(): LiveData<List<Guest>>
}