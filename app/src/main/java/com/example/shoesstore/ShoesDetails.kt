package com.example.shoesstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import com.example.shoesstore.databinding.FragmentShoesDetailsBinding
import com.example.shoesstore.viewmodel.shoeViewModel
import android.view.View as View


class ShoesDetails : Fragment() {

    private lateinit var viewModel: shoeViewModel

    private lateinit var _binding: FragmentShoesDetailsBinding
    private val binding
                get() = _binding

    private val sharedViewModel: shoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentShoesDetailsBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(shoeViewModel::class.java)

        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        _binding.saveBtn.setOnClickListener{
            sharedViewModel.addShoes(_binding.nameEdit.text.toString(),
                                     _binding.companyEdit.text.toString(),
                                     _binding.sizeEdit.text.toString(),
                                     _binding.descriptionEdit.text.toString())
            it.findNavController().navigate(ShoesDetailsDirections.actionShoesDetailsToShoesList())
        }

        _binding.cancelBtn.setOnClickListener{
            it.findNavController().navigate(ShoesDetailsDirections.actionShoesDetailsToShoesList())
        }

        return _binding.root
    }

}