package com.springer.patryk.myshelf.network.modules

import com.springer.patryk.myshelf.BuildConfig
import com.springer.patryk.myshelf.network.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import javax.inject.Singleton

/**
 * Created by Patryk on 2018-02-17.
 */
@Module
class RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(httpClient: OkHttpClient, converter: Converter.Factory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}