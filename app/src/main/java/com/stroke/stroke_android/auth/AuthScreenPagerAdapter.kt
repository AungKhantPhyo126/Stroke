package com.stroke.stroke_android.auth

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.stroke.stroke_android.auth.tabs.get_phone_number.GetPhoneNumberFragment
import com.stroke.stroke_android.auth.tabs.verify_otp.VerifyOtpFragment

class AuthScreenPagerAdapter(fragment: Fragment, private val onTap: (String, Int) -> Unit) :
    FragmentStateAdapter(fragment) {

    var phoneNumber: String = ""
    var requestId: Int = 0

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GetPhoneNumberFragment(onTap = fun(phone: String, requestId: Int) {
                phoneNumber = phone
                this.requestId = requestId
                onTap(phone, requestId)
                notifyItemChanged(1)
            })
            1 -> VerifyOtpFragment(phoneNumber, requestId)
            else -> GetPhoneNumberFragment(onTap = fun(phone: String, requestId: Int) {
                phoneNumber = phone
                this.requestId = requestId
                onTap(phone, requestId)
                notifyItemChanged(1)
            })
        }
    }
}