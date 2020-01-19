package com.charlezz.multimodulesample

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.charlezz.multimodulesample.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainComponent.factory()
            .create(
                (application as App).appComponent,
                MainModule(),
                this
            )
            .inject(this)
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.clickEvent.observe(this, Observer {
            when (it) {
                MainMenu.PHOTO_ACTIVITY->startActivity(Intent(this, Class.forName(it.canonicalName)))
            }
        })
    }
}
