package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager
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
        if(requestCode == 101 && resultCode == 23){
            val bundle = Bundle()
            bundle.putString("updateExpValue", data?.getStringExtra("updateExpValue"))
            bundle.putString("updateUniValue", data?.getStringExtra("updateUniValue"))
            bundle.putString("updateSkillsValue", data?.getStringExtra("updateSkillsValue"))
            manager.findFragmentByTag("professionalInfoFragment")?.arguments = bundle
        }
        if(requestCode == 101 && resultCode == 24){
            val bundle = Bundle()
            bundle.putString("nameUpdate", data?.getStringExtra("nameUpdate"))
            bundle.putString("surnameUpdate", data?.getStringExtra("surnameUpdate"))
            bundle.putString("birthDayUpdate", data?.getStringExtra("birthDayUpdate"))
            bundle.putString("ageUpdate", data?.getStringExtra("ageUpdate"))
            manager.findFragmentByTag("personalInfoFragment")?.arguments = bundle
        }
    }
}