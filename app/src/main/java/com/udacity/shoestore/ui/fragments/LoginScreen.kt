package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginScreenBinding


class LoginScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding :LoginScreenBinding = DataBindingUtil.inflate(inflater,
            R.layout.login_screen,container,false)
        binding.loginBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_loginScreen_to_welcomeScreen)
        }
        binding.signupBtn.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_loginScreen_to_welcomeScreen)
        }
        return binding.root
    }
}
