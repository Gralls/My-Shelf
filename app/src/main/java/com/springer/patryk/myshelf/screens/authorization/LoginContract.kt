package com.springer.patryk.myshelf.screens.authorization

import com.springer.patryk.myshelf.base.BaseContract
import com.springer.patryk.myshelf.models.User

/**
 * Created by Patryk on 2018-02-19.
 */
interface LoginContract {
    interface View : BaseContract.View {
        fun openHomePage()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun onUserSignedIn(user: User?)
        fun onAnonymousClicked()
    }
}