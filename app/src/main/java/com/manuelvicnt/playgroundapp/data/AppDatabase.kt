package com.manuelvicnt.playgroundapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Log::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao
}
