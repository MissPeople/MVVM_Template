package com.wzp.mvvm_template.data.remote.dataSource

import com.wzp.mvvm_template.data.remote.network.Result
import com.wzp.mvvm_template.data.remote.network.ApiService
import com.wzp.mvvm_template.data.remote.network.ServiceBuilder
import com.wzp.mvvm_template.data.remote.network.ServiceBuilder.await
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.domain.model.User
import javax.inject.Inject

class ApiServiceDataSourceImpl @Inject constructor() : ApiServiceDataSource {
    private val apiService = ServiceBuilder.create(ApiService::class.java)


    override suspend fun login(loginInfo: LoginInfo): Result<User> {
        return apiService.login(loginInfo.name, loginInfo.password).await()
    }
}