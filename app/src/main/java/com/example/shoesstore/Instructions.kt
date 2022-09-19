package com.example.shoesstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.shoesstore.databinding.FragmentInstructionsBinding


class Instructions : Fragment() {

    private lateinit var binding: FragmentInstructionsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentInstructionsBinding.inflate(inflater, container, false)

        var count = 0

        binding.toInstructions2.setOnClickListener {
            if(count == 0) {
            binding.instructionlabel1.text = "Instruction 2"
            binding.instrucionDesc.text = "You can logout by pressing the 3 dots in the top right corner and select logout."
            binding.toInstructions2.text = "Let's go"
            count++
            }
            else {
                it.findNavController().navigate(InstructionsDirections.actionInstructionsToShoesList())
            }
        }

        return binding.root
    }

}