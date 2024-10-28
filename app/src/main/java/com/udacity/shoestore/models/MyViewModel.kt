package com.udacity.shoestore.models

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.Add

class MyViewModel : ViewModel (){
  var  shoeslst:MutableLiveData<MutableList<Shoe>> = MutableLiveData<MutableList<Shoe>>()
    var userslst:MutableLiveData<HashMap<String,String>> = MutableLiveData<HashMap<String,String>>()
    fun add (shoe: Shoe?)
{
    if (shoe != null) {
        shoeslst.value?.add(shoe)
    }

}
    fun checkAuth(name: String,password: String):Boolean {
        return  userslst.value?.get(name).equals(password)
    }
    fun addUser(name:String,password:String){
         userslst.value?.put(name,password)
    }
    fun checkex(name:String):Boolean{
       return userslst.value?.contains(name) ==true
    }
}