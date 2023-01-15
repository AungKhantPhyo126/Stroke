package com.stroke.stroke_android.data_layers.dto

import com.squareup.moshi.Json

data class SendOtpApiResponseDto(
    val status: String?,
    val message: String?,
    @field:Json(name = "request_id")
    val requestId: Int?
)