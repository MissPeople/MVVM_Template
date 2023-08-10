package com.wzp.mvvm_template.data.repository.login

import com.wzp.mvvm_template.data.remote.dataSource.ApiServiceDataSource
import com.wzp.mvvm_template.data.remote.dataSource.ApiServiceDataSourceImpl
import com.wzp.mvvm_template.data.remote.network.ApiResponse
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.domain.model.User

class LoginRepositoryImpl : LoginRepository {
    private val apiServiceDataSource = ApiServiceDataSourceImpl()

    override suspend fun login(loginInfo: LoginInfo): ApiResponse<User> {
        return apiServiceDataSource.login(loginInfo)
    }
}