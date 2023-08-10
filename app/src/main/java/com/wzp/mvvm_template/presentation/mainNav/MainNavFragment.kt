package com.wzp.mvvm_template.presentation.mainNav

import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.presentation.base.BaseFragment
import com.wzp.mvvm_template.databinding.FragmentMainNavBinding

class MainNavFragment : BaseFragment<FragmentMainNavBinding, ViewModel>(
    FragmentMainNavBinding::inflate,
){
    override fun fragmentInit() {
        (childFragmentManager.findFragmentById(R.id.content_container) as NavHostFragment).apply {
            binding.bottomNav.setupWithNavController(this.navController)
        }
    }
}