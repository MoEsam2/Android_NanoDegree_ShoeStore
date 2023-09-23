package com.example.android_nanodegree_shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_nanodegree_shoestore.R
import com.example.android_nanodegree_shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        binding.nextButton.setOnClickListener {
            navigateToInstructionsFragment()
        }

        return binding.root
    }
    private fun navigateToInstructionsFragment() {
        val action = WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
        findNavController().navigate(action)
    }
}