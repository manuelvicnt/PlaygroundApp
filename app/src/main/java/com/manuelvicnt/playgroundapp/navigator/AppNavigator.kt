package com.manuelvicnt.playgroundapp.navigator

enum class Screens {
    Home,
    AllLogs
}

interface AppNavigator {
    fun navigateTo(screen: Screens)
}