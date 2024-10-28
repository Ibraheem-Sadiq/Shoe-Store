package com.udacity.shoestore.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionBinding
import com.udacity.shoestore.databinding.WelcomeScreenBinding

class Welcome: Fragment(R.layout.welcome_screen) {
    lateinit var binding:WelcomeScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.welcome_screen,container,false)

        var name =WelcomeArgs.fromBundle(requireArguments()).name
        binding.welcomeTvName.text=name
        binding.welcomeBtnStart.setOnClickListener(View.OnClickListener {
            findNavController().navigate(WelcomeDirections.actionWelcomeToInstructions())
        })

        return return binding.root
    }
}