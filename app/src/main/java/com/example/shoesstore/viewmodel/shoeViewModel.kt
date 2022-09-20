package com.example.shoesstore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoesstore.module.Shoe

class ShoeViewModel: ViewModel() {

    private val _shoeList =MutableLiveData<MutableList<Shoe>>()
    val shoeName = MutableLiveData<String>()
    val shoeList:LiveData<MutableList<Shoe>> get() = _shoeList

    init {
        shoeName.value = ""
        _shoeList.value = mutableListOf()
    }

    fun addShoes(name: String, company: String, size: String, description: String){
        val shoe =Shoe(name, company, size, description)
        _shoeList.value!!.add(shoe)
    }

}