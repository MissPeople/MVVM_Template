package com.wzp.mvvm_template.ui.mainNav.home

import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.base.BaseFragment
import com.wzp.mvvm_template.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding, ViewModel>(
    FragmentHomeBinding::inflate
) {
    override fun fragmentInit() {
        binding.tvHome.setOnClickListener {
            requireActivity().findNavController(R.id.app_nav).navigate(R.id.action_mainNavFragment_to_testFragment)
        }
    }
}