package com.springer.patryk.myshelf.base

import android.support.annotation.StringRes

/**
 * Created by Patryk on 2018-02-18.
 */
interface BaseView {
    fun showError(error: Throwable)
    fun showErrorMessage(errorMessage: String)
    fun showErrorMessage(@StringRes stringResId: Int)
    fun showMessage(@StringRes stringResId: Int)
    fun showMessage(message: String)
}