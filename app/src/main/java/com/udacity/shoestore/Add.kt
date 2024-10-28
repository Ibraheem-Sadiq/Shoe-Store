package com.udacity.shoestore

import android.app.Activity
import android.app.ActivityManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentAddBinding
import com.udacity.shoestore.databinding.WelcomeScreenBinding
import com.udacity.shoestore.models.MyViewModel
import com.udacity.shoestore.models.Shoe


class Add : Fragment() {
    lateinit var  binding: FragmentAddBinding
    val viewModel : MyViewModel by  activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_add,container,false)
        binding.shoe=Shoe("", 0.00, "", "")
       binding.add.setOnClickListener(){
nav(binding.shoe)
       }
         return binding.root
    }

    fun  nav(shoe:Shoe?){
        viewModel.add(shoe )
        findNavController().navigate(AddDirections.actionAdd2ToShoesList())
    }
}