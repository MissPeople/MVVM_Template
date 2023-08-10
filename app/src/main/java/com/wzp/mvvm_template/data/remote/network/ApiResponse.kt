package com.wzp.mvvm_template.data.remote.network

sealed class ApiResponse<out T> {
    data class OnSuccess<out T>(val response: T) : ApiResponse<T>()
    data class OnError(val errorMessage: String) : ApiResponse<Nothing>()
    object OnLoading : ApiResponse<Nothing>()
}
