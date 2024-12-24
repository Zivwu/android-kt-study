package com.example.ktstudy.login.data.api

import com.example.comm.model.NetResult
import com.example.ktstudy.login.model.Pet
import com.example.ktstudy.login.model.User
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @GET("/pet/findByStatus")
     fun getPets(@Query("status") status: String): List<Pet>


    @POST()
    suspend fun login():User



    /**
     * 注册
     * @param username  用户名
     * @param password  密码
     * @param repassword  确认密码
     */
    @FormUrlEncoded
    @POST("/user/register")
     fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): NetResult<User?>?

}