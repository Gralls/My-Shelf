package com.springer.patryk.myshelf.models

import android.net.Uri
import com.google.android.gms.auth.api.signin.GoogleSignInAccount

/**
 * Created by Patryk on 2018-02-19.
 */
data class User(var userId: String?, var fullName: String?, var name: String?, var surname: String?,
                var email: String?, var photoUrl: Uri?) {
    constructor(user: GoogleSignInAccount) : this(user.id, user.displayName, user.givenName,
            user.familyName, user.email, user.photoUrl)
}