package com.springer.patryk.myshelf.di

import com.springer.patryk.myshelf.screens.authorization.LoginActivity
import com.springer.patryk.myshelf.screens.authorization.LoginModule
import com.springer.patryk.myshelf.screens.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Patryk on 2018-02-17.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(LoginModule::class))
    internal abstract fun loginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector()
    internal abstract fun splashActivity(): SplashActivity
}