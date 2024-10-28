package com.udacity.shoestore.models

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionBinding
import com.udacity.shoestore.databinding.ItemBinding
import com.udacity.shoestore.databinding.ShoesListBinding

class ShoesList: Fragment(R.layout.shoes_list) {
    lateinit var binding: ShoesListBinding

    val viewModel : MyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.shoes_list,container,false)
        setHasOptionsMenu(true)
        viewModel.shoeslst.observe(viewLifecycleOwner,Observer{shoeslst ->
          if (shoeslst.isEmpty()==false)
              shoeslst.forEach { item->
                  val   bindingmini:ItemBinding=   DataBindingUtil.inflate(inflater, R.layout.item, container, false)
                  bindingmini.item = item
                  binding.list.addView(bindingmini.root)
              }
          })
        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(ShoesListDirections.actionShoesListToAdd2())
        }
        return return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logout)
        findNavController().navigate(ShoesListDirections.actionShoesListToLogin())
        return super.onOptionsItemSelected(item)
    }
}