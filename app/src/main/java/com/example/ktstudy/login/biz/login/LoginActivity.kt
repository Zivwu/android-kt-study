package com.example.ktstudy.login.biz.login

import androidx.activity.ComponentActivity
import com.example.ktstudy.login.model.User
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LoginActivity  : ComponentActivity(){
    var user : User  = User(1,"2",111).copy()
}