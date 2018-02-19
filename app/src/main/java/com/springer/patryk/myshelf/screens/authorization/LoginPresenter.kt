package com.springer.patryk.myshelf.screens.authorization

import com.springer.patryk.myshelf.base.BasePresenterImpl
import com.springer.patryk.myshelf.models.User
import javax.inject.Inject

/**
 * Created by Patryk on 2018-02-19.
 */
class LoginPresenter @Inject constructor() : BasePresenterImpl<LoginContract.View>(),
        LoginContract.Presenter {

    override fun onAnonymousClicked() {
        getViewOrThrow()?.openHomePage()
    }

    override fun onUserSignedIn(user: User?) {
        if (user != null) {
            getViewOrThrow()?.openHomePage()
        } else {
            getViewOrThrow()?.showErrorMessage(R.string.signing_failure)
        }
    }

}