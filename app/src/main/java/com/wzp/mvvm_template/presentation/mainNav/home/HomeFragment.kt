package com.wzp.mvvm_template.presentation.mainNav.home

import androidx.navigation.findNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.presentation.base.BaseFragment
import com.wzp.mvvm_template.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    FragmentHomeBinding::inflate,
    HomeViewModel::class.java
) {
    override fun fragmentInit() {
        binding.tvHome.setOnClickListener {
            requireActivity().findNavController(R.id.app_nav).navigate(R.id.action_mainNavFragment_to_testFragment)
        }
    }
}