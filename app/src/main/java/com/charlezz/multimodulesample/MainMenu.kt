package com.charlezz.multimodulesample

sealed class Destination(val scheme:String, val host:String)
object Photo: Destination(BuildConfig.COMMON_SCHEME, BuildConfig.PHOTO_HOST)