package com.example.shoesstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoesstore.databinding.FragmentOnBoardingBinding


class onBoarding : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)

        binding.toInstruction.setOnClickListener {
            it.findNavController().navigate(onBoardingDirections.actionOnBoardingToInstructions())
        }

        return binding.root
    }
}