package com.wzp.mvvm_template.domain.model

import com.squareup.moshi.Json

data class User(
    @Json(name = "data")
    val data: Entity? = null,
    @Json(name = "errorCode")
    val errorCode: Int = 0,
    @Json(name = "errorMessage")
    val errorMessage: String? = null
) {
    data class Entity(
        @Json(name = "admin")
        val admin: Boolean?,
        @Json(name = "chapterTops")
        val chapterTops: List<String>?,
        @Json(name = "coinCount")
        val coinCount: Int?,
        @Json(name = "collectIds")
        val collectIds: List<String>?,
        @Json(name = "email")
        val email: String?,
        @Json(name = "icon")
        val icon: String?,
        @Json(name = "id")
        val id: Long?,
        @Json(name = "nickname")
        val nickname: String?,
        @Json(name = "password")
        val password: String?,
        @Json(name = "publicName")
        val publicName: String?,
        @Json(name = "token")
        val token: String?,
        @Json(name = "type")
        val type: Int?,
        @Json(name = "username")
        val username: String?
    )
}
