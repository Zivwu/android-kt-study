package com.example.ktstudy.login.biz.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ktstudy.login.model.User
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject


@HiltViewModel
class LoginViewModel  @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel()  {

    val loginLiveData = MutableLiveData<User?>()


}