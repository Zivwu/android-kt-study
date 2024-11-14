package com.example.ktstudy.login.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier

@JsonClass(generateAdapter = true)
data class User (
    @Json(name = "11")
    var id: Long,
                  var name: String? ,
                  var signTime: Long){


    var age: Int = 0




}
