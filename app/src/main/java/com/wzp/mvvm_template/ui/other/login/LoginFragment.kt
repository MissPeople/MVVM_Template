package com.wzp.mvvm_template.ui.other.login

import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.base.BaseFragment
import com.wzp.mvvm_template.databinding.FragmentLoginBinding

class LoginFragment : BaseFragment<FragmentLoginBinding, ViewModel>(
    FragmentLoginBinding::inflate,
) {
    override fun fragmentInit() {
        binding.tvLogin.setOnClickListener {
            findNavController().navigate(
                R.id.mainNavFragment,
                null,
                NavOptions.Builder().setPopUpTo(R.id.loginFragment,true).build()
            )
        }
    }

}