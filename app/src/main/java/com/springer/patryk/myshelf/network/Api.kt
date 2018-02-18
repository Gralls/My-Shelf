package com.springer.patryk.myshelf.network

import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Patryk on 2018-02-18.
 */
interface Api {
    @GET("volumes")
    fun getVolumes(@Query("q") query: String): Observable<Response<Unit>>
}