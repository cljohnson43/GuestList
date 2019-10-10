package com.example.guestlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "guests")
class Guest private constructor(
    @PrimaryKey var id: Int?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "relatiion") val relation: String
) {
    constructor(name: String, relation: String) :
            this(id = null, name = name, relation = relation)
}
