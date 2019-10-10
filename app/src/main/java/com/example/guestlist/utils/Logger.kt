package com.example.guestlist.utils

import android.util.Log

const val DEBUG_TAG = "DEBUG_GUEST"

object Logger {
    fun log(msg: String, tag: String = DEBUG_TAG) {
        Log.d(tag, msg)
    }

}