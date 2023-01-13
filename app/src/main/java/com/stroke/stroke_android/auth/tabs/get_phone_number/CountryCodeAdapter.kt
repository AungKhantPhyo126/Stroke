package com.stroke.stroke_android.auth.tabs.get_phone_number

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.stroke.stroke_android.databinding.ItemCountryCodeBinding

class CountryCodeAdapter(
    private val context: Context,
    private val codeList: List<CountryCode>
) : BaseAdapter() {

    override fun getCount() = codeList.size

    override fun getItem(p0: Int) = codeList[p0]

    override fun getItemId(p0: Int): Long = codeList[p0].id.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var binding = ItemCountryCodeBinding.inflate(
            LayoutInflater.from(context),
            p2,
            false
        )
        Glide.with(context).load(codeList[p0].flag).into(binding.ivFlag)
        binding.tvPrefixCode.text = codeList[p0].prefixCode
        return binding.root
    }

}
