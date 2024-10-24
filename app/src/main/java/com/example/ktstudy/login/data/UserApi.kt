package com.example.ktstudy.login.data

import com.example.ktstudy.login.model.User
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUser(): User

}