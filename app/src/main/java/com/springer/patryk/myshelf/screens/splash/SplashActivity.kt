package com.springer.patryk.myshelf.screens.splash

import android.os.Bundle
import com.springer.patryk.myshelf.screens.main.MainActivity
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.intentFor

/**
 * Created by Patryk on 2018-02-17.
 */
class SplashActivity : DaggerAppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(intentFor<MainActivity>())
        finish()
    }
}