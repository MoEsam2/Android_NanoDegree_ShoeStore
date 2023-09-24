package com.example.android_nanodegree_shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.android_nanodegree_shoestore.R
import com.example.android_nanodegree_shoestore.databinding.FragmentShoeDetailBinding
import com.example.android_nanodegree_shoestore.viewmodel.ShoeViewModel
import com.google.android.material.snackbar.Snackbar

class ShoeDetailFragment : Fragment() {

    private val viewModel: ShoeViewModel by activityViewModels()

    private val binding by lazy {
        FragmentShoeDetailBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.restNewShoe()
        binding.viewModel = viewModel


        binding.saveButton.setOnClickListener {
            if (viewModel.addNewShoe()) {
                navigateToShoeListFragment()
            } else {
                Snackbar.make(
                    requireView(),
                    getString(R.string.incomplete_text),
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }


        binding.cancelButton.setOnClickListener {
            navigateToShoeListFragment()
        }

        return binding.root
    }

    private fun navigateToShoeListFragment() {
        val action = ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
        findNavController().navigate(action)
    }
}