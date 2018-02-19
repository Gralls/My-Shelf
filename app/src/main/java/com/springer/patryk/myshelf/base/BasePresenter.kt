package com.springer.patryk.myshelf.base

/**
 * Created by Patryk on 2018-02-18.
 */
interface BasePresenter<V : BaseView> {
    fun attachView(view: V)
    fun detachView()
    fun getViewOrThrow(): V?

}