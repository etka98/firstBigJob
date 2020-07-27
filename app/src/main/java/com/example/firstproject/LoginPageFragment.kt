package com.example.firstproject

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.loginpage_layout, container, false)
        val loginBtn = view.findViewById<Button>(R.id.logInBtn)
        val usernameText = view.findViewById<EditText>(R.id.usernameText)
        val passwordText = view.findViewById<EditText>(R.id.passwordText)
        loginBtn.setOnClickListener {
            val intent = Intent()
            val username = usernameText.text.toString()
            val password = passwordText.text.toString()
            if(username != "" && password != ""){
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                activity!!.setResult(99, intent)
                activity!!.finish()
            }
            else{
                Toast.makeText(requireContext(), "PLEAS ENTER USERNAME AND PASSWORD", Toast.LENGTH_LONG).show()
            }

        }
        return view
    }
}