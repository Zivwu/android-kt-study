package com.example.ktstudy.login.biz.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.flowWithLifecycle
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
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.math.BigInteger
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: UserRepository
) : ViewModel() {

    private val loginLiveData = MutableLiveData<User?>()


    fun initPets(): Unit {
        getPets()
            .onStart {  }
            .onEach {  }
            .onCompletion {  }


    }

    fun getPets(): Flow<List<String>> {
        return repository.getPets()

    }


    fun fibonacci(): Flow<BigInteger> = flow<BigInteger> {
        var x = BigInteger.ZERO
        var y = BigInteger.ONE
        while (true) {
        emit(x)
            x = y . also { y += x }
    }
    }

}