package com.udacity.shoestore.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.viewmodels.ShoeStoreInventoryViewModel

class ShoeDetailFragment : Fragment() {
    private val viewModel: ShoeStoreInventoryViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val binding = FragmentShoeDetailBinding.inflate(inflater)

        binding.cancelButton.setOnClickListener { v: View ->
            v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        }

        viewModel.resetShoe()

        binding.viewModel = viewModel

        binding.saveButton.setOnClickListener { v: View ->
            if (viewModel.validateAndAddShoe()) {
                v.findNavController().navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
            } else {
                Toast.makeText(requireContext(), "One or more fields are empty!", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}