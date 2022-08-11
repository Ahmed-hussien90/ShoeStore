package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.WelcomeScreenBinding


class WelcomeScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: WelcomeScreenBinding =
            DataBindingUtil.inflate(inflater, R.layout.welcome_screen, container, false)

        binding.nextBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_welcomeScreen_to_instructionScreen)
        }

        return binding.root
    }
}