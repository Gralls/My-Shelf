package com.springer.patryk.myshelf.screens.authorization

import com.springer.patryk.myshelf.base.BasePresenter
import com.springer.patryk.myshelf.base.BaseView
import com.springer.patryk.myshelf.models.User

/**
 * Created by Patryk on 2018-02-19.
 */
interface LoginContract {
    interface View : BaseView {
        fun openHomePage()
    }

    interface Presenter : BasePresenter<View> {
        fun onUserSignedIn(user: User?)
        fun onAnonymousClicked()
    }
}