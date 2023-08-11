package com.wzp.mvvm_template.data.remote.network

import com.wzp.mvvm_template.domain.model.User
import retrofit2.Call
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("/user/login")
    fun login(
        @Query("username") username: String,
        @Query("password") password: String,
    ): Call<User>
}