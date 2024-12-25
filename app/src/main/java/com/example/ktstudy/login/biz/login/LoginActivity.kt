package com.example.ktstudy.login.biz.login

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.lifecycle.viewModelScope
import androidx.viewbinding.ViewBinding
import com.example.ktstudy.databinding.ActivityLoginBinding
import com.example.ktstudy.login.data.UserRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.launch
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import javax.inject.Inject


@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>() {

    private val viewModel: LoginViewModel by viewModels()
    lateinit var mBinding: ActivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(mBinding.root)
//        viewModel.getPets().forEach {
//            print("ss")
//        }
        val fibonacci = viewModel.fibonacci();

//        fibonacci.take(100).collect { println(it) }
        viewModel.viewModelScope.launch (context =  Dispatchers.IO){  }
        mBinding.btnCommit.setOnClickListener {

           lifecycleScope.launch {
               viewModel.getPets()
                   .onStart {
                       println(it)
                   }.onEach {
                       println("onEach  :${it.toString()}")
                   }.onCompletion {
                       println("onCompletion  : ")
                   }.collect{
                       println("collect  :${it.toString()}")
                   }
           }

//            viewModel.getPets().flowWithLifecycle(lifecycle)
//                .asLiveData().observe(this) {
//                mBinding.edName.text = it.toString();
//            }


        }

    }

}



@AndroidEntryPoint
class LoginFragment : Fragment() {
    private val viewModel by viewModels<LoginViewModel>()
    private val viewModel2: LoginViewModel by activityViewModels(
    )
}


open class BaseActivity<T : ViewBinding> : ComponentActivity() {
//    open lateinit var mBinding: T;

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(mBinding.root)
//    }
//
//     fun initView()  {
////         val type = javaClass
////         val type2 = javaClass.genericSuperclass
////         val typeArguments = (type2!! as ParameterizedType).actualTypeArguments;
////
////        for (type3:Type in typeArguments){
////            print(type3 is ViewBinding)
////
////        }
////         @Suppress("UNCHECKED_CAST") val vbClass: Class<T> = typeArguments[0]  as Class<T>
////         val method = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
////         var mbind   = method.invoke(this, layoutInflater)
////         print("1")
//
//     }
//
//    inline fun <reified VM : ViewBinding>  initViewBinding(): VM {
//        val binding = VM::class.java.getMethod("inflate", LayoutInflater::class.java).invoke(null, layoutInflater) as VM
//        return binding;
//    }
}
