package com.example.firstproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class FirstPageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.firstpage_layout, container, false)
        val loginBtn = view.findViewById<Button>(R.id.loginBtn)
        val tag = "loginPageFragment"
        val loginPageFragment  = LoginPageFragment()
        loginBtn.setOnClickListener {
            val manager = requireActivity().supportFragmentManager
            val transaction = manager.beginTransaction()
            transaction.addToBackStack(tag)
            transaction.replace(R.id.myFirstFrameLayout, loginPageFragment, tag)
            transaction.commit()
        }
        return view
    }
}