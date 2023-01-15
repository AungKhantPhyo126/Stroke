package com.stroke.stroke_android.repositories_impl

import com.stroke.stroke_android.api.AuthService
import com.stroke.stroke_android.commonKotlin.Resource
import com.stroke.stroke_android.data_layers.dto.OtpVerificationRequestDto
import com.stroke.stroke_android.repositories.AuthRepo
import javax.inject.Inject

class AuthRepoImpl @Inject constructor(
    private val authService: AuthService
) : AuthRepo {

    override suspend fun sendOtp(phoneNumber: String): Resource<List<String>> {
        return try {
            val response = authService.sendOtp(
                OtpVerificationRequestDto(
                    phoneNumber = phoneNumber,
                    requestId = null,
                    otp = null
                )
            )
            if (response.isSuccessful) {
                Resource.Success(
                    listOf(
                        response.body()?.message ?: "send otp succeeded",
                        response.body()?.requestId?.toString() ?: "-1"
                    )
                )
            } else {
                Resource.Error("send otp failed")
            }
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }

    override suspend fun verifyOtp(
        phoneNumber: String,
        requestId: Int,
        otp: Int
    ): Resource<String> {
        return try {
            val response = authService.verifyOtp(
                OtpVerificationRequestDto(
                    phoneNumber = phoneNumber,
                    requestId = requestId,
                    otp = otp
                )
            )
            if (response.isSuccessful) {
                Resource.Success(response.body()?.message ?: "verify otp succeeded")
                /** Save Token */
            } else {
                Resource.Error("verify otp failed")
            }
        } catch (e: Exception) {
            Resource.Error(e.message)
        }
    }

    override suspend fun getTokenForTesting(clientId: String, username: String): Resource<String> {
        TODO("Not yet implemented")
    }
}