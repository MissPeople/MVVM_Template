package com.wzp.mvvm_template.presentation.other.splash

import android.animation.ValueAnimator
import androidx.core.animation.doOnEnd
import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.wzp.mvvm_template.R
import com.wzp.mvvm_template.databinding.FragmentSplashBinding
import com.wzp.mvvm_template.presentation.base.BaseFragment

class SplashFragment : BaseFragment<FragmentSplashBinding, ViewModel>(
    FragmentSplashBinding::inflate
) {
    private val animation = ValueAnimator.ofInt(0, 1000)
    override fun fragmentInit() {
        animation.apply {
            duration = 3000
            addUpdateListener {
                binding.progressHorizontal.progress = it.animatedValue as Int
                binding.tv.text = it.animatedValue.toString()
            }
            addListener(doOnEnd {
                findNavController().navigate(
                    R.id.loginFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.splashFragment, true)
                        .setLaunchSingleTop(true)
                        .build()
                )
            })
            start()
        }
    }
}