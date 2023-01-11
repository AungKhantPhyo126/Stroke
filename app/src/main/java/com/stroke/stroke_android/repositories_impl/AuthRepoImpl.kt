package com.stroke.stroke_android.repositories_impl

import com.stroke.stroke_android.commonKotlin.Resource
import com.stroke.stroke_android.repositories.AuthRepo
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(): AuthRepo {

    override suspend fun sendOtp(phoneNumber: String): Resource<String> {
        TODO("Not yet implemented")
    }

    override suspend fun verifyOtp(
        phoneNumber: String,
        requestId: Int,
        otp: Int
    ): Resource<String> {
        TODO("Not yet implemented")
    }

    override suspend fun getTokenForTesting(clientId: String, username: String): Resource<String> {
        TODO("Not yet implemented")
    }
}