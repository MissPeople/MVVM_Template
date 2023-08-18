package com.wzp.mvvm_template.presentation.other.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.databinding.FragmentLoginBinding
import com.wzp.mvvm_template.domain.model.LoginInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etName.setText("wanandroidtest202301")
        binding.etPwd.setText("zxcvbnm")

        binding.tvLogin.setOnClickListener {
            viewModel.notifyEvent(
                LoginContract.Event.Login(LoginInfo(binding.etName.text.toString(), binding.etPwd.text.toString()))
            )
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.effect.collect {
                    when (it) {
                        is LoginContract.Effect.Error -> {
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(requireContext(), "登录失败", Toast.LENGTH_SHORT).show()
                        }

                        is LoginContract.Effect.Loading -> {
                            binding.progressBar.visibility = View.VISIBLE
                        }

                        is LoginContract.Effect.Popup -> {
                            jump()
                        }
                    }
                }
            }
        }
    }

    private fun jump() {
        findNavController().navigate(
            R.id.mainNavFragment,
            null,
            NavOptions.Builder()
                .setPopUpTo(R.id.loginFragment, true)
                .setLaunchSingleTop(true)
                .build()
        )
    }

}