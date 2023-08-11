package com.wzp.mvvm_template.util

import android.content.Context
import android.content.SharedPreferences

class SPUtil(context: Context) {
    private var sharedPreferences: SharedPreferences

    //SPUtil对应的常量参数
    companion object {
        const val SP_NAME = "account"
        const val PASSWORD_KEY = "pwd"
        const val NICKNAME_KEY = "nickname"
        const val ACCOUNT_KEY = "account"
    }

    init {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)
    }

    fun setSPValue(key: String, any: Any) {
        val edit = sharedPreferences.edit()
        when (any) {
            is Int -> {
                edit.putInt(key, any)
            }

            is Float -> {
                edit.putFloat(key, any)
            }

            is Boolean -> {
                edit.putBoolean(key, any)
            }

            is Long -> {
                edit.putLong(key, any)
            }

            is String -> {
                edit.putString(key, any)
            }
        }
        edit.apply()
    }

    fun getSPValue(key: String, defaultValue: Any?): Any? = when (defaultValue) {
        is Int -> {
            sharedPreferences.getInt(key, defaultValue)
        }

        is Float -> {
            sharedPreferences.getFloat(key, defaultValue)
        }

        is Boolean -> {
            sharedPreferences.getBoolean(key, defaultValue)
        }

        is Long -> {
            sharedPreferences.getLong(key, defaultValue)
        }

        is String -> {
            sharedPreferences.getString(key, defaultValue)
        }

        is MutableSet<*> -> {
            sharedPreferences.getStringSet(key, defaultValue as MutableSet<String>?)
        }

        else -> {
            null
        }
    }
}
