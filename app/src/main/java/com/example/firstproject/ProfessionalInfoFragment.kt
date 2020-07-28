package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ProfessionalInfoFragment : Fragment() {

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
        return view
    }
}