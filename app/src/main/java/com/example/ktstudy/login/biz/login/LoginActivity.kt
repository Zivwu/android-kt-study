package com.example.ktstudy.login.biz.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.ktstudy.databinding.ActivityLoginBinding
import com.example.ktstudy.login.model.User
import dagger.hilt.android.AndroidEntryPoint
import java.lang.reflect.ParameterizedType
import javax.inject.Inject
import kotlin.reflect.full.companionObject


@AndroidEntryPoint
class LoginActivity  : BaseActivity<ActivityLoginBinding>(){

    private val viewModel: LoginViewModel by viewModels()

//    var mb : ActivityLoginBinding  by binding();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var mBinding : ActivityLoginBinding =  ActivityLoginBinding.inflate(this.layoutInflater);
        setContentView(mBinding.root)

        viewModel.loginLiveData.observe(this) {
            with(mBinding) {
                it?.let {  }

            }
        }

    }


}

@AndroidEntryPoint
class  LoginFragment  : Fragment() {
    private val viewModel by viewModels<LoginViewModel> ()
    private val viewModel2: LoginViewModel by activityViewModels (
    )
}

 open class  BaseActivity<T:ViewBinding> :ComponentActivity(){
      lateinit  var  mBinding : T ;


     fun initViewBinding() :T {
         val type = javaClass.genericSuperclass
         val vbClass: Class<T> = type!!.saveAs<ParameterizedType>().actualTypeArguments[0].saveAs()
         val method = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
         mBinding = method.invoke(this, layoutInflater)!!.saveAsUnChecked()
         setContentView(mBinding.root)
         return mBinding;
     }
}

inline fun <reified T> Any.saveAs() : T{
    return this as T
}

@Suppress("UNCHECKED_CAST")
fun <T> Any.saveAsUnChecked() : T{
    return this as T
}