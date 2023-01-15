package com.stroke.stroke_android.api

import com.stroke.stroke_android.data_layers.dto.OtpVerificationRequestDto
import com.stroke.stroke_android.data_layers.dto.SendOtpApiResponseDto
import com.stroke.stroke_android.data_layers.dto.VerifyOtpApiResponseDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("/api/send_otp")
    suspend fun sendOtp(@Body phoneNumber: OtpVerificationRequestDto): Response<SendOtpApiResponseDto>

    @POST("/api/verify_otp")
    suspend fun verifyOtp(@Body verifyOtpRequest: OtpVerificationRequestDto): Response<VerifyOtpApiResponseDto>

}