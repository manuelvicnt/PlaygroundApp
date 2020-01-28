package com.manuelvicnt.playgroundapp

import android.app.Activity
import android.content.Context
import androidx.room.Room
import com.manuelvicnt.playgroundapp.data.AppDatabase
import com.manuelvicnt.playgroundapp.data.LoggerLocalDataSource
import com.manuelvicnt.playgroundapp.navigator.AppNavigator
import com.manuelvicnt.playgroundapp.navigator.AppNavigatorImpl
import com.manuelvicnt.playgroundapp.util.DateFormatter

class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "my-database-name"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())
    val dateFormatter = DateFormatter()

    fun provideNavigator(activity: Activity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}
