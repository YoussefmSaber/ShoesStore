package com.example.shoesstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoesstore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.login.setOnClickListener{
            it.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnBoarding())
        }

        binding.register.setOnClickListener{
            it.findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToOnBoarding())
        }
        return binding.root
    }
}