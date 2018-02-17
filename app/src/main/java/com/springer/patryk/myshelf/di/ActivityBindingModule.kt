package com.springer.patryk.myshelf.di

import com.springer.patryk.myshelf.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Patryk on 2018-02-17.
 */
@Module
abstract class ActivityBindingModule {
    @ActivityScope
    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity
}