package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class PersonalInfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.personal_information_layout, container, false)
        val updateBtn = view.findViewById<Button>(R.id.updateBtn)
        updateBtn.setOnClickListener {
            val intent = Intent(requireContext(), PersonalInfoUpdate::class.java)
            requireActivity().startActivityForResult(intent, 101)
        }
        return view
    }


}