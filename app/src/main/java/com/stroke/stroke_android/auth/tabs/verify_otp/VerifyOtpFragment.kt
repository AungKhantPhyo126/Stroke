package com.stroke.stroke_android.auth.tabs.verify_otp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.stroke.stroke_android.commonKotlin.Resource
import com.stroke.stroke_android.databinding.FragmentVerifyOtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyOtpFragment(private val phoneNumber: String, private val requestId: Int) : Fragment() {

    private lateinit var binding: FragmentVerifyOtpBinding
    private val viewModel by viewModels<VerifyOtpViewModel>()

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

        binding.pvOtpCode.addTextChangedListener { editable ->
            editable?.toString()?.let {
                viewModel.onCodeChange(it)
            }
        }

        viewModel.otpLive.observe(viewLifecycleOwner) {
            binding.btnVerifyOtp.isEnabled = (it.isNotBlank() && it.length == 6)
        }

        binding.btnVerifyOtp.setOnClickListener {
            viewModel.onVerifyTap(phoneNumber = phoneNumber, requestId = requestId)
            Log.i("request id", requestId.toString())
        }

        viewModel.verifyOtpStatusLive.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    Toast.makeText(requireContext(), it.data?.first().toString(), Toast.LENGTH_LONG)
                        .show()
                }
                is Resource.Error -> {}
            }
        }

    }

}