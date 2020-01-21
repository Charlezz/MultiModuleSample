package com.charlezz.core.di

import android.app.ActivityManager
import android.app.Application
import android.content.Context
import android.location.LocationManager
import dagger.Module
import dagger.Provides

@Module
object AppModule {
    @JvmStatic
    @Provides
    fun locationManager(application: Application) : LocationManager = application.getSystemService(
        Context.LOCATION_SERVICE) as LocationManager
    @JvmStatic
    @Provides
    fun activityManager(application: Application) : ActivityManager = application.getSystemService(
        Context.ACTIVITY_SERVICE) as ActivityManager
}