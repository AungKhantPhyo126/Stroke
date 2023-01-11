package com.stroke.stroke_android.repositories

import com.stroke.stroke_android.commonKotlin.Resource

interface AuthRepo {

    suspend fun sendOtp(phoneNumber: String): Resource<String>

    suspend fun verifyOtp(phoneNumber: String, requestId: Int, otp: Int): Resource<String>

    suspend fun getTokenForTesting(clientId: String, username: String): Resource<String>


}