package com.wzp.mvvm_template.presentation.other.login

import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.presentation.base.UiEffect
import com.wzp.mvvm_template.presentation.base.UiEvent
import com.wzp.mvvm_template.presentation.base.UiState

object LoginContract {
    sealed class Event: UiEvent{
        data class Login(val loginInfo: LoginInfo) : Event()
    }

    data class State(
        val showPassword: Boolean = false,
    ) : UiState

    sealed class Effect : UiEffect {
        data class ToastMsg(val msg: String) : Effect()
    }
}