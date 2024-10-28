package com.udacity.shoestore.models

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginBinding
import java.time.Duration

class Login : Fragment(R.layout.login) {
    lateinit var binding: LoginBinding
    val viewModel: MyViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initialize(inflater, container)
        binding.loginBtnLogin.setOnClickListener(View.OnClickListener {
            OnclickLogin(
                binding.loginEtEmail.text.toString(),
                binding.loginEtPassword.text.toString()
            )
        })
        binding.loginBtnNew.setOnClickListener(View.OnClickListener {
            register(binding.loginEtEmail.text.toString(), binding.loginEtPassword.text.toString())
        })
        return binding.root
    }

    fun OnclickLogin(name: String, password: String) {
        if (viewModel.checkex(name)) {
            if (viewModel.checkAuth(name, password))
                login(name)
            else
                Toast.makeText(this.context, "wrong password or email ", Toast.LENGTH_SHORT).show()

        } else
            Toast.makeText(this.context, "no such user ", Toast.LENGTH_SHORT).show()

    }

    fun register(name: String, password: String) {
        if (!viewModel.checkex(name)) {
            viewModel.addUser(name, password)
            Toast.makeText(this.context, "created", Toast.LENGTH_SHORT).show()
        }
        else
            Toast.makeText(this.context, "already exist", Toast.LENGTH_SHORT).show()
    }

    fun login(name: String) {
        findNavController().navigate(LoginDirections.actionLoginToWelcome(name))
    }

    fun initialize(inflater: LayoutInflater, container: ViewGroup?) {
        if (viewModel.userslst.value == null)
            viewModel.userslst.value = HashMap<String, String>()
        if (viewModel.shoeslst.value == null)
            viewModel.shoeslst.value = mutableListOf<Shoe>()
        binding = DataBindingUtil.inflate(inflater,R.layout.login,container,false)

    }
}