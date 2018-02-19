package com.springer.patryk.myshelf.base

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Patryk on 2018-02-19.
 */
open class BasePresenterImpl<V : BaseView> : BasePresenter<V> {
    protected val disposable = CompositeDisposable()
    private var view: V? = null

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        disposable.clear()
        this.view = null
    }

    override fun getViewOrThrow(): V? {
        return view
    }
}