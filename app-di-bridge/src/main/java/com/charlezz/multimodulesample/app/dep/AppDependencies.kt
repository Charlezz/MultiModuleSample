package com.charlezz.multimodulesample.app.dep

import android.app.ActivityManager
import android.app.Application
import android.content.Context

interface AppDependencies {
    fun getApplication(): Application
    fun activityManager(): ActivityManager
}

interface AppDependenciesProvider {
    fun appDependencies(): AppDependencies
}

fun Context.appDependencies(): AppDependencies {
    return (applicationContext as AppDependenciesProvider).appDependencies()
}