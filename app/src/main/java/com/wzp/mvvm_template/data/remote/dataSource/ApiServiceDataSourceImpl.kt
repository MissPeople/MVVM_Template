package com.wzp.mvvm_template.data.remote.dataSource

import com.wzp.mvvm_template.data.remote.network.ApiService
import com.wzp.mvvm_template.data.remote.network.Result
import com.wzp.mvvm_template.domain.model.LoginInfo
import com.wzp.mvvm_template.domain.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ApiServiceDataSourceImpl @Inject constructor(
    private val service: ApiService
) : ApiServiceDataSource {

    override suspend fun login(loginInfo: LoginInfo): Result<User> {
        return service.login(loginInfo.name, loginInfo.password).await()
    }
}

suspend fun <T> Call<T>.await(): Result<T> {
    return suspendCoroutine { continuation ->
        enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                val body = response.body() as T
                val code = response.code()
                if (code == 200) {
                    continuation.resume(Result.OnSuccess(body))
                } else {
                    continuation.resume(Result.OnError(code.toString()))
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) {
                continuation.resume(Result.OnError("error"))
            }
        })
    }
}