package com.example.ktstudy

import androidx.activity.ComponentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.comm.model.NetResult
import com.example.ktstudy.login.data.api.UserApi
import com.example.ktstudy.login.model.User
import dagger.Module
import dagger.Provides
import dagger.assisted.Assisted
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Named


//@Module(includes =[ActivityComponent::class] )
//@InstallIn(ActivityComponent::class)
object MainModule {

//    @Provides
//    @Named("main")
//     fun  name():String {
//         return "main-name"
//    }


//    @Provides
//    fun  affsed( savedStateHandle: SavedStateHandle):String {
//        return "savedStateHandle"
//    }

}


@HiltViewModel
class FeatureXFragmentViewModel @Inject constructor(
     private val savedStateHandle: SavedStateHandle
) : ViewModel() {
     val entityId: String = savedStateHandle.get<String>("ENTITY_ID_EXTRA")!!
     // ...
}

class  MyLifeOb : DefaultLifecycleObserver {



}