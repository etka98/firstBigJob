package com.example.firstproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class WelcomePageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.welcomepage_layout, container, false)
        val bundle = arguments
        val welcomeText = view.findViewById<TextView>(R.id.welcomeText)
        welcomeText.text ="WELCOME " + bundle?.getString("username")
        val personalInfoBtn = view.findViewById<Button>(R.id.personalInfoBtn)
        personalInfoBtn.setOnClickListener {
            val manager = requireActivity().supportFragmentManager
            val personalInfoFragment = PersonalInfoFragment()
            val tag = "personalInfoFragment"
            val transaction = manager.beginTransaction()
            transaction.addToBackStack(tag)
            transaction.replace(R.id.mySecondFrameLayout, personalInfoFragment, tag)
            transaction.commit()
        }
        return view
    }
}