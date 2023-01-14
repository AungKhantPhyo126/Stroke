package com.stroke.stroke_android.auth

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stroke.stroke_android.auth.tabs.get_phone_number.GetPhoneNumberFragment
import com.stroke.stroke_android.auth.tabs.verify_otp.VerifyOtpFragment

class AuthScreenPagerAdapter(fragment: Fragment, private val onTap: (String) -> Unit) :
    FragmentStateAdapter(fragment) {

    var phoneNumber: String = ""

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GetPhoneNumberFragment(onTap = fun(phone: String) {
                phoneNumber = phone
                onTap(phone)
                notifyItemChanged(1)
            })
            1 -> VerifyOtpFragment(phoneNumber)
            else -> GetPhoneNumberFragment(onTap = fun(phone: String) {
                phoneNumber = phone
                onTap(phone)
                notifyItemChanged(1)
            })
        }
    }
}