package com.example.shoesstore

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shoesstore.databinding.FragmentShoesListBinding
import com.example.shoesstore.viewmodel.shoeViewModel
import kotlinx.android.synthetic.main.shoe_item.view.*
import timber.log.Timber


class ShoesList : Fragment() {

    private lateinit var binding: FragmentShoesListBinding
    private val viewModel:  shoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentShoesListBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.removeAllViews()
            for (shoe in it) {
                addShoe(shoe.name)
                Timber.tag("strange").i(shoe.name)
            }
        }

        binding.addShoeButton.setOnClickListener{
            it.findNavController().navigate(ShoesListDirections.actionShoesListToShoesDetails())
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.loginFragment ->
                findNavController().navigate(ShoesListDirections.actionShoesListToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    fun addShoe(name: String){
        val view = layoutInflater.inflate(R.layout.shoe_item, null)
        view.textView.text = name
        binding.shoeList.addView(view.textView)
    }

}