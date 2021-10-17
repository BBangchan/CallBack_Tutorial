package com.example.callback_tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

// completion block을 이용한 비동기처리

class MainActivity : AppCompatActivity() {
    val TAG : String ="로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called()")

        someCallBackMethod(completion = {
            Log.d(TAG, "MainActivity - 컴플레션 블럭 호출됨 / it : $it")
        })
    }

    fun someCallBackMethod(completion: (String) -> Unit){
        Log.d(TAG, "MainActivity - someCallBackMethod() called()")

        Handler().postDelayed({
           completion("종료")
        },3000L)
    }
}