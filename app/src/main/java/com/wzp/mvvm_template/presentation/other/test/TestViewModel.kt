package com.wzp.mvvm_template.presentation.other.test

import com.wzp.mvvm_template.presentation.base.BaseViewModel
import com.wzp.mvvm_template.presentation.base.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(): BaseViewModel(

){
    override fun handleEvent(event: UiEvent) {
    }
}