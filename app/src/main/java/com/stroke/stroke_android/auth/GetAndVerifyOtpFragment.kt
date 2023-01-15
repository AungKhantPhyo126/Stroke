package com.stroke.stroke_android.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.stroke.stroke_android.databinding.FragmentGetAndVerifyOtpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetAndVerifyOtpFragment : Fragment() {

    private lateinit var binding: FragmentGetAndVerifyOtpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGetAndVerifyOtpBinding.inflate(inflater, container, false)
            .also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPagerAdapter = AuthScreenPagerAdapter(this) { _, _ ->
            binding.vpGetPhoneAndOtp.currentItem = 1
        }

        binding.vpGetPhoneAndOtp.adapter = viewPagerAdapter

        binding.vpGetPhoneAndOtp.isUserInputEnabled = false

        binding.btnBack.setOnClickListener {
            if (binding.vpGetPhoneAndOtp.currentItem == 1) {
                binding.vpGetPhoneAndOtp.currentItem = 0
            }
        }

    }

}