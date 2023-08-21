package com.wzp.mvvm_template.data.repository.login

import com.wzp.mvvm_template.data.remote.dataSource.ApiServiceDataSource
import com.wzp.mvvm_template.data.remote.network.Result
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.domain.model.User
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val apiServiceDataSource: ApiServiceDataSource
) : LoginRepository {

    override suspend fun login(loginInfo: LoginInfo): Result<User> {
        return apiServiceDataSource.login(loginInfo)
    }
}