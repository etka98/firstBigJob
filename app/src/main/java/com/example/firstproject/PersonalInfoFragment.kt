package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class PersonalInfoFragment : Fragment() {
    lateinit var nameText : TextView
    lateinit var surnameText: TextView
    lateinit var birthDayText : TextView
    lateinit var ageText : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.personal_information_layout, container, false)
        val updateBtn = view.findViewById<Button>(R.id.updateBtn)
        nameText = view.findViewById(R.id.nameText)
        surnameText = view.findViewById(R.id.surnameText)
        birthDayText = view.findViewById(R.id.birthDayText)
        ageText = view.findViewById(R.id.ageText)
        updateBtn.setOnClickListener {
            val intent = Intent(requireContext(), PersonalInfoUpdate::class.java)
            requireActivity().startActivityForResult(intent, 101)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val bundle = arguments
        if(bundle != null){
            nameText.text = "NAME : " + bundle.getString("nameUpdate")
            surnameText.text = "SURNAME : " + bundle.getString("surnameUpdate")
            birthDayText.text = "BIRTH DAY : " + bundle.getString("birthDayUpdate")
            ageText.text = "AGE : " + bundle.getString("ageUpdate")
        }
    }


}