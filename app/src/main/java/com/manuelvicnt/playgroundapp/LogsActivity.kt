package com.manuelvicnt.playgroundapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LogsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = "Your logs"
        }
    }
}