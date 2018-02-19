package com.springer.patryk.myshelf.screens.splash

import android.os.Bundle
import com.springer.patryk.myshelf.base.BaseActivity
import com.springer.patryk.myshelf.screens.authorization.LoginActivity
import org.jetbrains.anko.intentFor

/**
 * Created by Patryk on 2018-02-17.
 */
class SplashActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(intentFor<LoginActivity>())
        finish()
    }
}