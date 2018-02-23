package com.springer.patryk.myshelf.screens.authorization

import com.springer.patryk.myshelf.di.ActivityScope
import dagger.Binds
import dagger.Module

/**
 * Created by Patryk on 2018-02-19.
 */
@Module
abstract class LoginModule {
    @ActivityScope
    @Binds
    abstract fun bindLoginPresenter(presenter: LoginPresenter): LoginContract.Presenter

    @ActivityScope
    @Binds
    abstract fun bindLoginView(view: LoginActivity): LoginContract.View
}