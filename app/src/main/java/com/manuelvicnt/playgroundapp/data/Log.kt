package com.manuelvicnt.playgroundapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Log(val msg: String, val timestamp: Long) {

    @PrimaryKey(autoGenerate = true)
    var uid: Long = 0
}