package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class PersonalInfoUpdate : AppCompatActivity() {
    lateinit var updateBtn : Button
    lateinit var nameText : EditText
    lateinit var surnameText : EditText
    lateinit var birthDayText : EditText
    lateinit var ageText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info_update)
        define()
        giveAction()
    }

    fun define(){
        updateBtn = findViewById(R.id.updateBtn2)
        nameText = findViewById(R.id.nameText2)
        surnameText = findViewById(R.id.surnameText2)
        birthDayText = findViewById(R.id.birthDayText2)
        ageText = findViewById(R.id.ageText2)
    }

    fun giveAction(){
        updateBtn.setOnClickListener {
            var intent = Intent()
            val name = nameText.text.toString()
            val surname = surnameText.text.toString()
            val birthDay = birthDayText.text.toString()
            val age = ageText.text.toString()
            intent.putExtra("nameUpdate", name)
            intent.putExtra("surnameUpdate", surname)
            intent.putExtra("birthDayUpdate", birthDay)
            intent.putExtra("ageUpdate", age)
            this.setResult(24, intent)
            this.finish()
        }
    }
}