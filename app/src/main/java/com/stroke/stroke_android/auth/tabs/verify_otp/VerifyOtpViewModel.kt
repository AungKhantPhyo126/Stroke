package com.stroke.stroke_android.auth.tabs.verify_otp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stroke.stroke_android.commonKotlin.Resource
import com.stroke.stroke_android.repositories_impl.AuthRepoImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VerifyOtpViewModel @Inject constructor(
    private val authRepo: AuthRepoImpl
) : ViewModel() {

    private val _otpLive: MutableLiveData<String> = MutableLiveData("")
    val otpLive: LiveData<String>
        get() = _otpLive


    fun onCodeChange(code: String) {
        _otpLive.value = code
    }

    private val _verifyOtpStatusLive = MutableLiveData<Resource<String>>()
    val verifyOtpStatusLive: LiveData<Resource<String>>
        get() = _verifyOtpStatusLive

    fun onVerifyTap(phoneNumber: String, requestId: Int) {
        _verifyOtpStatusLive.value = Resource.Loading()
        viewModelScope.launch {
            _verifyOtpStatusLive.value = authRepo.verifyOtp(
                phoneNumber = phoneNumber,
                requestId = requestId,
                otp = _otpLive.value?.toInt() ?: -1
            )
        }
    }

}