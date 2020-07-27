package com.example.firstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AuthenticationActivity : AppCompatActivity() {
    lateinit var firstPageFragment: FirstPageFragment
    val manager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)
        define()
        val tag = "firstPageFragment"
        val transaction = manager.beginTransaction()
        transaction.addToBackStack(tag)
        transaction.replace(R.id.myFirstFrameLayout, firstPageFragment, tag)
        transaction.commit()
    }

    fun define(){
        firstPageFragment = FirstPageFragment()
    }
}