package com.wzp.mvvm_template.data.remote.network

sealed class Result<out T> {
    data class OnSuccess<out T>(val response: T) : Result<T>()
    data class OnError(val errorMessage: String) : Result<Nothing>()
    object OnLoading : Result<Nothing>()
}
