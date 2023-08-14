package com.wzp.mvvm_template.presentation.other.login

import androidx.lifecycle.viewModelScope
import com.wzp.mvvm_template.data.remote.network.ApiResponse
import com.wzp.mvvm_template.data.repository.login.LoginRepositoryImpl
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.presentation.base.BaseViewModel
import com.wzp.mvvm_template.presentation.base.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : BaseViewModel() {

    private val _state = MutableStateFlow(
        LoginContract.State()
    )
    val state: StateFlow<LoginContract.State> = _state

    override fun handleEvent(event: UiEvent) {
        when (event) {
            is LoginContract.Event.Login -> {
                //login(event.loginInfo)
                triggerEffect { LoginContract.Effect.ToastMsg("loading") }
            }
        }
    }

    private fun login(loginInfo: LoginInfo) {
        viewModelScope.launch {
            LoginRepositoryImpl().login(loginInfo).apply {
                when (this) {
                    is ApiResponse.OnLoading -> {
                        triggerEffect { LoginContract.Effect.ToastMsg("loading") }
                    }

                    is ApiResponse.OnError -> {
                        triggerEffect { LoginContract.Effect.ToastMsg("loading") }
                    }

                    is ApiResponse.OnSuccess -> {
                        triggerEffect { LoginContract.Effect.ToastMsg(this.response.toString()) }
                    }
                }
            }

        }
    }

}