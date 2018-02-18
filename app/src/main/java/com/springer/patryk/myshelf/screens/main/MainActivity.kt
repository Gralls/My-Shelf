package com.springer.patryk.myshelf.screens.main

import android.os.Bundle
import com.github.ajalt.timberkt.d
import com.springer.patryk.myshelf.R
import com.springer.patryk.myshelf.network.Api
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    @Inject
    lateinit var api: Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        api.getVolumes("flowers+inauthor:keyes")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ next -> d { next.message() } })
    }
}
