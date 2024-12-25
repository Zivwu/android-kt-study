package com.example.ktstudy.login.data

import com.example.ktstudy.login.data.api.UserApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import kotlin.system.measureTimeMillis

class UserRepository @Inject constructor() {
    private  val userApi : UserApi;
    init {
        val builder = OkHttpClient.Builder()
            .addNetworkInterceptor(HttpLoggingInterceptor())


        val retrofit = Retrofit.Builder()
            .client(builder.build())
            .baseUrl(" http://127.0.0.1:4523/m1/1438726-2065681-default/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
         userApi = retrofit.create(UserApi::class.java)
    }



    var index =1;
     fun getPets(status: String=""): Flow<List<String>> {
         index  ++ ;
         return  flow {
             val pets = listOf("Nile $index", "Amazon $index", "Yangtze $index")
             emit(pets)

         }

    }


}