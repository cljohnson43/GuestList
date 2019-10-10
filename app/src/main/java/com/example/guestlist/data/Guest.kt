package com.example.guestlist.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = Guest.TABLE_NAME)
class Guest private constructor(
    @PrimaryKey var id: Long?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "relatiion") val relation: String
) {
    constructor(name: String, relation: String) :
            this(id = null, name = name, relation = relation)

    companion object {
        const val TABLE_NAME = "guests"
    }

    override fun toString(): String {
        return "Name - $name Relation - $relation ID - ${id ?: "null"}"
    }
}
