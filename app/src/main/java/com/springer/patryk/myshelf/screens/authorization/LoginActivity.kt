package com.springer.patryk.myshelf.screens.authorization

import android.content.Intent
import android.os.Bundle
import com.github.ajalt.timberkt.Timber
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.springer.patryk.myshelf.R
import com.springer.patryk.myshelf.base.BaseActivity
import com.springer.patryk.myshelf.models.User
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    companion object {
        private val SIGNING_REQUEST_CODE = 9001
    }

    @Inject lateinit var presenter: LoginContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var googleSignOptions: GoogleSignInOptions = GoogleSignInOptions.Builder(
                GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestEmail().build()
        val googleSignClient = GoogleSignIn.getClient(this, googleSignOptions)
        signInWithGoogle.setOnClickListener {
            startActivityForResult(googleSignClient.signInIntent, SIGNING_REQUEST_CODE)
        }
    }

    override fun onStart() {
        super.onStart()
        presenter.attachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.detachView()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SIGNING_REQUEST_CODE) {
            var task = GoogleSignIn.getSignedInAccountFromIntent(data)
            var user: User? = null
            try {
                user = User(task.getResult(ApiException::class.java))
            } catch (e: ApiException) {
                Timber.e(e)
            }
            presenter.onUserSignedIn(user)
        }
    }

    override fun openHomePage() {
        showMessage("YAY")
    }
}
