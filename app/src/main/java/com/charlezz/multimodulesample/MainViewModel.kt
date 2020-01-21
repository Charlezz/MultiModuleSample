package com.charlezz.multimodulesample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
class MainViewModel @Inject constructor(val app:Application) : AndroidViewModel(app){
    val clickEvent = MutableLiveData<Destination>()

    fun onClick(mainMenu: Destination){
        clickEvent.value = mainMenu
    }
}
