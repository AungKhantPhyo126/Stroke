package com.stroke.stroke_android.auth.tabs.get_phone_number

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.stroke.stroke_android.databinding.FragmentGetPhoneNumberBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetPhoneNumberFragment(private val onTap: (String) -> Unit) : Fragment(),
    AdapterView.OnItemSelectedListener {

    private lateinit var binding: FragmentGetPhoneNumberBinding
    private val viewModel by viewModels<GetPhoneNumberViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentGetPhoneNumberBinding.inflate(
            inflater, container, false
        ).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val countryCodeAdapter = CountryCodeAdapter(requireContext(), viewModel.mockList)
        binding.spinnerCountryCode.adapter = countryCodeAdapter
        binding.spinnerCountryCode.onItemSelectedListener = this

        binding.btnConfirmPhone.setOnClickListener {
            onTap(viewModel.onSubmit())
        }

        binding.etPhoneNumber.addTextChangedListener { editable ->
            editable?.toString()?.let {
                viewModel.onPhoneNumberChange(it)
            }
        }

        viewModel.phoneLive.observe(viewLifecycleOwner) {
            binding.btnConfirmPhone.isEnabled = it.isNotBlank()
        }

        binding.ibClear.setOnClickListener {
            binding.etPhoneNumber.setText("")
        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        viewModel.onCountryCodeChange(p2)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}