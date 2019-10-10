package com.example.guestlist.data

import androidx.room.*

@Dao
interface GuestDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGuests(vararg guest: Guest): List<Long>

    @Delete
    fun deleteGuests(vararg guest: Guest): Int

    @Query("SELECT * FROM ${Guest.TABLE_NAME}")
    fun loadAllGuests(): Array<Guest>
}