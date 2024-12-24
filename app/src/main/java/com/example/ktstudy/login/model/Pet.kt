package com.example.ktstudy.login.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier


/**
 * Pet
 */
@JsonClass(generateAdapter = true)
data class Pet (

    /**
     * 分组
     */
    val category: Category,

    /**
     * 宠物ID编号
     */
    val id: Long,

    /**
     * 名称
     */
    val name: String,

    /**
     * 照片URL
     */
    val photoUrls: List<String>,

    /**
     * 宠物销售状态
     */
    val status: Status,

    /**
     * 标签
     */
    val tags: List<Tag>
)


/**
 * 分组
 *
 * Category
 */
@JsonClass(generateAdapter = true)
data class Category (
    /**
     * 分组ID编号
     */
    val id: Long? = null,

    /**
     * 分组名称
     */
    val name: String? = null
)

/**
 * 宠物销售状态
 */
//@JsonClass(generateAdapter = true)
enum class Status(val value: String) {
    Available("available"),
    Pending("pending"),
    Sold("sold");

    companion object {
        public fun fromValue(value: String): Status = when (value) {
            "available" -> Available
            "pending"   -> Pending
            "sold"      -> Sold
            else        -> throw IllegalArgumentException()
        }
    }
}

/**
 * Tag
 */
@JsonClass(generateAdapter = true)
data class Tag (
    /**
     * 标签ID编号
     */
    val id: Long? = null,

    /**
     * 标签名称
     */
    val name: String? = null
)
