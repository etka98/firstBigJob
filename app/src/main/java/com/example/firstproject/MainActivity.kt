package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startIntent()
    }

    fun startIntent(){
        val intent = Intent(this, AuthenticationActivity::class.java)
        startActivityForResult(intent, 101)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101 && resultCode == 99){
            val welcomePageFragment = WelcomePageFragment()
            val manager = supportFragmentManager
            val tag = "welcomePageFragment"
            val bundle = Bundle()
            bundle.putString("username", data?.getStringExtra("username"))
            bundle.putString("password", data?.getStringExtra("password"))
            welcomePageFragment.arguments = bundle
            val transaction = manager.beginTransaction()
            transaction.addToBackStack(tag)
            transaction.replace(R.id.mySecondFrameLayout, welcomePageFragment, tag)
            transaction.commit()
        }
    }
}