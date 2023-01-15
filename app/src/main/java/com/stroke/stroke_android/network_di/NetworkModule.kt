package com.stroke.stroke_android.network_di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.stroke.stroke_android.api.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

const val BASE_URL = "http://13.215.252.104"

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor(Interceptor { chain: Interceptor.Chain ->
                val request =
                    chain.request().newBuilder().addHeader("Accept", "application/json").build()
                chain.proceed(request)
            })
        }.build()
    }

    @Provides
    @Singleton
    fun provideAuthService(retrofit: Retrofit) = retrofit.create<AuthService>()

}