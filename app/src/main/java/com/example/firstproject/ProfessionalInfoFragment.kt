package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfessionalInfoFragment : Fragment() {
    lateinit var experience : TextView
    lateinit var uni : TextView
    lateinit var skills : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.professional_information_layout, container, false)
        val updateBtn = view.findViewById<Button>(R.id.updateButton)
        updateBtn.setOnClickListener {
            val intent = Intent(requireContext(), ProfessionalInfoUpdate::class.java)
            requireActivity().startActivityForResult(intent, 101)
        }
        experience = view.findViewById<TextView>(R.id.experienceText)
        uni = view.findViewById<TextView>(R.id.universityText)
        skills = view.findViewById<TextView>(R.id.skillsText)
        return view
    }

    override fun onStart() {
        super.onStart()
        val bundle = arguments
        if(bundle != null){
            experience.text = bundle.getString("updateExpValue")
            uni.text = bundle.getString("updateUniValue")
            skills.text = bundle.getString("updateSkillsValue")
        }
        Toast.makeText(requireContext(), "start", Toast.LENGTH_LONG).show()
    }
}