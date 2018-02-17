package com.springer.patryk.myshelf.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Created by Patryk on 2018-02-17.
 */
@Module
abstract class ApplicationModule {
    @Binds
    internal abstract fun bindContext(application: Application): Context
}