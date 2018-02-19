package com.springer.patryk.myshelf.screens.authorization

import android.net.Uri
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.springer.patryk.myshelf.R
import com.springer.patryk.myshelf.models.User
import org.junit.Before
import org.junit.Test

/**
 * Created by Patryk on 2018-02-19.
 */
class LoginPresenterTest {
    private val view = mock<LoginContract.View>()
    private lateinit var presenter: LoginPresenter

    @Before
    fun setUp() {
        presenter = LoginPresenter()
        presenter.attachView(view)
    }

    @Test
    fun successLoginTest() {
        var user: User = User("1", "fullName", "name", "surname",
                "email", Uri.EMPTY)
        presenter.onUserSignedIn(user)
        verify(view).openHomePage()
    }

    @Test
    fun unsuccessfulLoginTest() {
        var user: User? = null
        presenter.onUserSignedIn(user)
        verify(view).showMessage(R.string.signing_failure)
    }
}