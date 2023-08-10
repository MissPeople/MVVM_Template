package com.wzp.mvvm_template.presentation.other.test

import androidx.lifecycle.ViewModel
import com.wzp.mvvm_template.presentation.base.BaseFragment
import com.wzp.mvvm_template.databinding.FragmentTestBinding

class TestFragment : BaseFragment<FragmentTestBinding, ViewModel>(
    FragmentTestBinding::inflate
) {
    override fun fragmentInit() {

    }
}