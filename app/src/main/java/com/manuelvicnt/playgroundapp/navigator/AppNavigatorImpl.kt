package com.manuelvicnt.playgroundapp.navigator

import android.content.Context
import android.content.Intent
import com.manuelvicnt.playgroundapp.ui.LogsActivity
import com.manuelvicnt.playgroundapp.ui.MainActivity

class AppNavigatorImpl(private val context: Context): AppNavigator {

    override fun navigateTo(screen: Screens) {
        when (screen) {
            Screens.Home -> {
                val intent = Intent(context, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
                context.startActivity(intent)
            }
            Screens.AllLogs -> {
                context.startActivity(Intent(context, LogsActivity::class.java))
            }
        }
    }
}