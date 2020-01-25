package com.manuelvicnt.playgroundapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.manuelvicnt.playgroundapp.LogApplication
import com.manuelvicnt.playgroundapp.R
import com.manuelvicnt.playgroundapp.data.LoggerLocalDataSource

class LogsActivity : AppCompatActivity() {

    private lateinit var logger: LoggerLocalDataSource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Your logs"
        }

        logger = (applicationContext as LogApplication).serviceLocator.loggerLocalDataSource

        logger.getAllLogs { logs ->
            Log.d("PLAYGROUND_APP", "PRINTING LOGS:")
            for (log in logs) {
                Log.d("PLAYGROUND_APP", log.msg)
            }
        }
    }
}