package com.example.comm.model

import com.example.ktstudy.login.model.User
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NetResult<T>(
    val data: T?,
    val errorCode: Int = 0,//服务器状态码 这里0表示请求成功
    val errorMsg: String = ""//错误信息
)