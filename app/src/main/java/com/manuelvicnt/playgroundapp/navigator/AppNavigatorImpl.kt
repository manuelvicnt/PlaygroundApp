package com.manuelvicnt.playgroundapp.navigator

import android.app.Activity
import android.content.Intent
import com.manuelvicnt.playgroundapp.ui.LogsActivity
import com.manuelvicnt.playgroundapp.ui.MainActivity

class AppNavigatorImpl(private val activity: Activity): AppNavigator {

    override fun navigateTo(screen: Screens) {
        when (screen) {
            Screens.Home -> {
                val intent = Intent(activity, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_CLEAR_TASK or
                        Intent.FLAG_ACTIVITY_NEW_TASK
                activity.startActivity(intent)
            }
            Screens.AllLogs -> {
                activity.startActivity(Intent(activity, LogsActivity::class.java))
            }
        }
    }
}
