package com.example.ktstudy

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
        var a:String  = "1";
        var  res = a.let {
            println("let"+this);
            var res = 2;
            it+res;
        }
        var res2 = a.run {
            println("run"+this);
            var res = 2;
            this+res;
        }

        var res3=  a.apply {
            println("apply"+this);

        }

        var res4=  a.also {
            println("also"+this);

        }

        println(a);

    }

    @Test
    fun cus() {
        GlobalScope.launch {
            repeat(1000) { i ->
                println("job: I'm sleeping $i ...")
                delay(500L)
            }
        }
    }
}



