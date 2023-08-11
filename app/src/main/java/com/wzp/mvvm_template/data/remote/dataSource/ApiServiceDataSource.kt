package com.wzp.mvvm_template.data.remote.dataSource

import com.wzp.mvvm_template.data.remote.network.ApiResponse
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.domain.model.User

interface ApiServiceDataSource {
    suspend fun login(loginInfo: LoginInfo): ApiResponse<User>
}