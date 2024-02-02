package com.cs4520.assignment1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val usernameField = view.findViewById<EditText>(R.id.username_field)
        val passwordField = view.findViewById<EditText>(R.id.password_field)
        val loginButton = view.findViewById<Button>(R.id.login_button)
        loginButton.setOnClickListener {
            val username = usernameField.text
            val password = passwordField.text
            if ((username.toString() == "admin") && (password.toString() == "admin")) {
                Toast.makeText(context, "Login successful", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, R.string.invalid_username_or_password, Toast.LENGTH_LONG)
                    .show()
            }

            username.clear()
            password.clear()
        }
        return view
    }
}