package com.example.ktstudy.login.data

import androidx.lifecycle.lifecycleScope
import com.example.comm.model.NetResult
import com.example.ktstudy.login.data.api.UserApi
import com.example.ktstudy.login.model.Pet
import com.example.ktstudy.login.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

class UserRepository @Inject constructor() {
      val userApi : UserApi;
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


    suspend fun getPets11(status: String  ="" ): List<String> {

//        return userApi.getPets("");

        return  listOf("Nile", "Amazon", "Yangtze");
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