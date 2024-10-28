package com.udacity.shoestore.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionBinding
import com.udacity.shoestore.databinding.WelcomeScreenBinding

class Instructions: Fragment(R.layout.instruction) {
    lateinit var binding: InstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.instruction,container,false)
        binding.instBtnShop.setOnClickListener(View.OnClickListener {
            findNavController().navigate(InstructionsDirections.actionInstructionsToShoesList())
        })
        return return binding.root
    }
}