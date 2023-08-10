package com.wzp.mvvm_template.domain.model

data class User(
    val data:Entity? = null,
    val errorCode:Int = 0,
    val errorMessage:String? = null
) {
    data class Entity(
        val admin: Boolean?,
        val chapterTops: List<String>?,
        val coinCount: Int?,
        val collectIds: List<String>?,
        val email: String?,
        val icon: String?,
        val id: Long?,
        val nickname: String?,
        val password: String?,
        val publicName: String?,
        val token: String?,
        val type: Int?,
        val username: String?
    )
}
