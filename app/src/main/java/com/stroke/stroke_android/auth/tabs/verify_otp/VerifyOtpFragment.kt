package com.stroke.stroke_android.auth.tabs.verify_otp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stroke.stroke_android.databinding.FragmentVerifyOtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyOtpFragment(private val phoneNumber: String) : Fragment() {

    private lateinit var binding: FragmentVerifyOtpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentVerifyOtpBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvBody.text = "We have sent OTP code on your mobile number ($phoneNumber)"

    }

}