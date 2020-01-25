package com.manuelvicnt.playgroundapp

import android.content.Context
import androidx.room.Room
import com.manuelvicnt.playgroundapp.data.AppDatabase
import com.manuelvicnt.playgroundapp.data.LoggerLocalDataSource
import com.manuelvicnt.playgroundapp.navigator.AppNavigator
import com.manuelvicnt.playgroundapp.navigator.AppNavigatorImpl

class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "my-database-name"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())

    fun provideNavigator(context: Context): AppNavigator {
        return AppNavigatorImpl(context)
    }
}
