package com.example.template.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.template.R
import com.example.template.authentication.signin.SigninFragment

class AuthenticationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.authentication_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SigninFragment.newInstance())
                .commitNow()
        }
    }
}