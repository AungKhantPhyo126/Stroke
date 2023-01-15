package com.stroke.stroke_android.data_layers.dto

import com.squareup.moshi.Json

data class OtpVerificationRequestDto(
    @field:Json(name = "phone_no")
    val phoneNumber: String,

    @field:Json(name = "request_id")
    val requestId: Int?,

    val otp: Int?

)
