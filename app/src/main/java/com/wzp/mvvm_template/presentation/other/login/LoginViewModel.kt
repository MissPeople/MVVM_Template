package com.wzp.mvvm_template.presentation.other.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.wzp.mvvm_template.data.remote.network.Result
import com.wzp.mvvm_template.data.repository.login.LoginRepository
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.presentation.base.BaseViewModel
import com.wzp.mvvm_template.presentation.base.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : BaseViewModel() {

    private val _state = MutableStateFlow(
        LoginContract.State()
    )
    val state: StateFlow<LoginContract.State> = _state

    override fun handleEvent(event: UiEvent) {
        when (event) {
            is LoginContract.Event.Login -> {
                triggerEffect { LoginContract.Effect.Loading }
                login(event.loginInfo)
            }
        }
    }

    private fun login(loginInfo: LoginInfo) {
        viewModelScope.launch {
            loginRepository.login(loginInfo).apply {
                when (this) {
                    is Result.OnLoading -> {
                        triggerEffect { LoginContract.Effect.Loading }
                    }

                    is Result.OnError -> {
                        triggerEffect { LoginContract.Effect.Error }
                    }

                    is Result.OnSuccess -> {
                        if(response.errorCode == -1) {
                            triggerEffect { LoginContract.Effect.Error }
                        } else {
                            triggerEffect { LoginContract.Effect.Popup }
                        }

                    }
                }
            }

        }
    }

}