package com.springer.patryk.myshelf.di

import android.app.Application
import com.springer.patryk.myshelf.MyShelfApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Patryk on 2018-02-17.
 */
@Singleton
@Component(modules = arrayOf(
        ApplicationModule::class,
        ActivityBindingModule::class,
        AndroidSupportInjectionModule::class,
        FragmentBindingModule::class
))
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    fun inject(application: MyShelfApplication)
    override fun inject(instance: DaggerApplication?)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): ApplicationComponent.Builder

        fun build(): ApplicationComponent
    }
}