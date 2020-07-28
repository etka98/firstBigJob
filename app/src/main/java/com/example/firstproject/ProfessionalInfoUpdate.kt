package com.example.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ProfessionalInfoUpdate : AppCompatActivity() {
    lateinit var updateBtn : Button
    lateinit var experienceText: EditText
    lateinit var uniText : EditText
    lateinit var skillsText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_professional_info_update)
        define()
        giveAction()
    }

    fun define(){
        updateBtn = findViewById(R.id.updateButton2)
        experienceText = findViewById(R.id.experienceText2)
        uniText = findViewById(R.id.universityText2)
        skillsText = findViewById(R.id.skillsText2)
    }

    fun giveAction(){
        updateBtn.setOnClickListener {
            val intent = Intent()
            val experience = experienceText.text.toString()
            val uni = uniText.text.toString()
            val skills = skillsText.text.toString()
            intent.putExtra("updateExpValue", experience)
            intent.putExtra("updateUniValue", uni)
            intent.putExtra("updateSkillsValue", skills)
            this.setResult(23,intent)
            this.finish()
        }
    }
}