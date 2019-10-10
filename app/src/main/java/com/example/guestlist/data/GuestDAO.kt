package com.example.guestlist.data

import androidx.room.*

@Dao
interface GuestDAO {
    // TODO look into defining what constitutes a conflict
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertGuest(guest: Guest): Long

    @Delete
    fun deleteGuest(guest: Guest): Int

    @Query("SELECT * FROM ${Guest.TABLE_NAME}")
    fun loadAllGuests(): List<Guest>
}