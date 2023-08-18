package com.wzp.mvvm_template.data.repository.login

import com.wzp.mvvm_template.data.remote.network.Result
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.domain.model.User

interface LoginRepository {
    suspend fun login(loginInfo: LoginInfo): Result<User>
}