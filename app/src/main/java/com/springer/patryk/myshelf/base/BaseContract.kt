package com.springer.patryk.myshelf.base

import android.support.annotation.StringRes

/**
 * Created by Patryk on 2018-02-23.
 */
interface BaseContract {
    interface View {
        fun showError(error: Throwable)
        fun showErrorMessage(errorMessage: String)
        fun showErrorMessage(@StringRes stringResId: Int)
        fun showMessage(@StringRes stringResId: Int)
        fun showMessage(message: String)
    }

    interface Presenter<V : View> {
        fun attachView(view: V)
        fun detachView()
        fun getViewOrThrow(): V?
    }
}