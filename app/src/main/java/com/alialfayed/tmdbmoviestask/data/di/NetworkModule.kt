package com.alialfayed.tmdbmoviestask.data.di

import com.alialfayed.tmdbmoviestask.utils.BASE_URL
import com.alialfayed.tmdbmoviestask.utils.REQUEST_TIME
import com.alialfayed.tmdbmoviestask.data.remote.api.ApiService
import com.ihsanbal.logging.Level
import com.ihsanbal.logging.LoggingInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.internal.platform.Platform
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{


    @Provides
    @Singleton
    fun provideHeadersInterceptor() = Interceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
//                    .addHeader("Authorization", NotificationActivity.TOKEN_API)
//                    .addHeader("Content-Type", "application/json")
                    .build()
            )
        }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): LoggingInterceptor {
        return LoggingInterceptor.Builder()
            .setLevel(Level.BASIC)
            .log(Platform.INFO)
            .request("Request")
            .response("Response")
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headersInterceptor: Interceptor,
        logging: LoggingInterceptor,
    ): OkHttpClient {
        return  OkHttpClient.Builder()
            .readTimeout(REQUEST_TIME, TimeUnit.MINUTES)
            .connectTimeout(REQUEST_TIME, TimeUnit.MINUTES)
            .addInterceptor(headersInterceptor)
            .addNetworkInterceptor(logging)
            .build()
    }


    @Provides
    @Singleton
    fun provideApiServices(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun getDynamicRetrofitClient(
        okHttpClient: OkHttpClient
    ): Retrofit {


        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

}
