package com.example.ktstudy.login.biz.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.ktstudy.login.data.UserRepository
import com.example.ktstudy.login.model.Pet
import com.example.ktstudy.login.model.User
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
      val repository: UserRepository
) : ViewModel()  {

    val loginLiveData = MutableLiveData<User?>()



    fun initPets(): LiveData<List<Pet>>{

       return flow {
           val res =  repository.userApi.getPets("available")
           emit(res)
       }.asLiveData()


    }


}