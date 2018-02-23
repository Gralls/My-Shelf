package com.springer.patryk.myshelf.base

import com.github.ajalt.timberkt.Timber
import dagger.android.support.DaggerFragment
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.support.v4.find

/**
 * Created by Patryk on 2018-02-19.
 */
open class BaseFragment : DaggerFragment(), BaseContract.View {
    override fun showErrorMessage(stringResId: Int) {
        longSnackbar(find(android.R.id.content), stringResId)
    }

    override fun showErrorMessage(errorMessage: String) {
        longSnackbar(find(android.R.id.content), errorMessage)
    }

    override fun showError(error: Throwable) {
        Timber.e(error)
        showErrorMessage(error.localizedMessage)
    }

    override fun showMessage(stringResId: Int) {
        longSnackbar(find(android.R.id.content), stringResId)
    }

    override fun showMessage(message: String) {
        longSnackbar(find(android.R.id.content), message)
    }
}