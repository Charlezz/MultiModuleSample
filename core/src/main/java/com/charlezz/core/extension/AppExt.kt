package com.charlezz.core.extension

import android.app.Application
import android.content.Intent

fun <T> Application.start(clazz: Class<T>){
    startActivity(Intent(this, clazz))
}