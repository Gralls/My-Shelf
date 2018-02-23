package com.springer.patryk.myshelf.base

import android.R
import com.github.ajalt.timberkt.Timber
import dagger.android.support.DaggerAppCompatActivity
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.find

/**
 * Created by Patryk on 2018-02-19.
 */
open class BaseActivity : DaggerAppCompatActivity(), BaseContract.View {
    override fun showErrorMessage(stringResId: Int) {
        longSnackbar(find(R.id.content), stringResId)
    }

    override fun showErrorMessage(errorMessage: String) {
        longSnackbar(find(R.id.content), errorMessage)
    }

    override fun showError(error: Throwable) {
        Timber.e(error)
        showErrorMessage(error.localizedMessage)
    }

    override fun showMessage(stringResId: Int) {
        longSnackbar(find(R.id.content), stringResId)
    }

    override fun showMessage(message: String) {
        Timber.d { message }
        longSnackbar(find(R.id.content), message)
    }

    fun setFragment(fragment: BaseFragment, containerId: Int) {
        supportFragmentManager.beginTransaction().apply { replace(containerId, fragment) }.commit()
    }

    fun addFragmentToBackStack(fragment: BaseFragment, containerId: Int) {
        supportFragmentManager.beginTransaction().apply {
            replace(containerId, fragment)
            addToBackStack(fragment::class.java.name)
        }.commit()
    }

}