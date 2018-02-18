package com.springer.patryk.myshelf.network.modules

import android.util.Log
import com.springer.patryk.myshelf.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Created by Patryk on 2018-02-17.
 */
@Module
class OkHttpModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(logger: HttpLoggingInterceptor, apiKeyInterceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(logger)
                .addInterceptor(apiKeyInterceptor)
                .build()
    }

    @Provides
    @Singleton
    fun provideLogger(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor(HttpLoggingInterceptor
                .Logger { message -> Log.d("OkHttp", message) })
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideApiKeyInterceptor(): Interceptor {
        return Interceptor { chain ->
            var originalRequest = chain.request()
            var originalUrl = originalRequest.url()
            var newUrl = originalUrl.newBuilder()
                    .addQueryParameter("key", BuildConfig.API_KEY)
                    .build()
            var requestBuilder = originalRequest.newBuilder()
                    .url(newUrl)
            chain.proceed(requestBuilder.build())
        }
    }
}