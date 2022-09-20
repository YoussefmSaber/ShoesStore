package com.example.shoesstore.module

import android.widget.EditText

data class Shoe(
    var name: String,
    var company: EditText,
    var size: EditText,
    var description: EditText)