package com.manuelvicnt.playgroundapp.ui

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.manuelvicnt.playgroundapp.LogApplication
import com.manuelvicnt.playgroundapp.R
import com.manuelvicnt.playgroundapp.data.LoggerLocalDataSource
import com.manuelvicnt.playgroundapp.navigator.AppNavigator
import com.manuelvicnt.playgroundapp.navigator.Screens

class MainActivity : AppCompatActivity() {

    private lateinit var logger: LoggerLocalDataSource
    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateFields()
        setupViews()
    }

    private fun populateFields() {
        logger = (applicationContext as LogApplication).serviceLocator.loggerLocalDataSource
        navigator = (applicationContext as LogApplication).serviceLocator.provideNavigator(this)
    }

    private fun setupViews() {
        findViewById<Button>(R.id.button1).setOnClickListener {
            logger.addLog("Interaction with Button 1")
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            logger.addLog("Interaction with Button 2")
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            logger.addLog("Interaction with Button 3")
        }

        findViewById<Button>(R.id.all_logs).setOnClickListener {
            logger.addLog("Interaction with See all logs button")
            navigator.navigateTo(Screens.AllLogs)
        }

        findViewById<Button>(R.id.delete_logs).setOnClickListener {
            logger.removeLogs()
        }
    }
}
