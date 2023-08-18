package com.wzp.mvvm_template.data.remote.network

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wzp.mvvm_template.util.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object ServiceBuilder {
    private const val TAG = "http_info"
    private val retrofit = buildRetrofit(createClient())

    private fun buildRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(
                MoshiConverterFactory.create(
                    Moshi.Builder()
                        .add(KotlinJsonAdapterFactory()).build()
                )
            )
            .build()
    }

    private fun createClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor { message ->
            Log.e(TAG, " = $message")
        }.apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.MILLISECONDS)
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(loggingInterceptor)
            .build()
    }

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

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
}

