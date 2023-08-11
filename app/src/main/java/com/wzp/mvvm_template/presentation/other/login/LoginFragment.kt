package com.wzp.mvvm_template.presentation.other.login

import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.databinding.FragmentLoginBinding
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.presentation.base.BaseFragment
import com.wzp.mvvm_template.util.LogUtil

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    FragmentLoginBinding::inflate,
    LoginViewModel::class.java
) {
    override fun fragmentInit() {
        binding.tvLogin.setOnClickListener {
            viewModel!!.notifyEvent(
                LoginContract.Event.Login(LoginInfo("wanandroidtest202301", "zxcvbnm"))
            )
        }
        lifecycleScope.launchWhenStarted {
            viewModel!!.effect.collect {
                when (it) {
                    is LoginContract.Effect.ToastMsg -> {
                        LogUtil.i(it.msg)
                        Toast.makeText(requireContext(), it.msg, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun jump() {
        findNavController().navigate(
            R.id.mainNavFragment,
            null,
            NavOptions.Builder().setPopUpTo(R.id.loginFragment, true).build()
        )
    }

}