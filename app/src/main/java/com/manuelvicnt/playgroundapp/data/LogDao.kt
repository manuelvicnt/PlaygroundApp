package com.manuelvicnt.playgroundapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LogDao {

    @Query("SELECT * FROM Log ORDER BY uid DESC")
    fun getAll(): List<Log>

    @Insert
    fun insertAll(vararg users: Log)

    @Query("DELETE FROM Log")
    fun nukeTable()
}
