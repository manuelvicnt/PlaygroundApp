package com.manuelvicnt.playgroundapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private val logger = LoggerLocalDataSource()
    private val navigator = AppNavigator(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViews()
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
    }
}
