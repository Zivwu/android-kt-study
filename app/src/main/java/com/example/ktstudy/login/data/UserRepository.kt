package com.example.ktstudy.login.data

import androidx.lifecycle.lifecycleScope
import com.example.comm.model.NetResult
import com.example.ktstudy.login.data.api.UserApi
import com.example.ktstudy.login.model.User
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class UserRepository @Inject constructor() {



    suspend fun  request(): NetResult<User?>? {

        val builder = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor())


        val retrofit = Retrofit.Builder()
            .client(builder.build())
            .baseUrl("https://www.wanandroid.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
        val userApi = retrofit.create(UserApi::class.java)

        return userApi.register("ming0001","a123456","a123456");



    }
}