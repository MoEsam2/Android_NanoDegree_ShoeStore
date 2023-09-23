package com.example.android_nanodegree_shoestore.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_nanodegree_shoestore.R
import com.example.android_nanodegree_shoestore.databinding.FragmentInstructionsBinding

class InstructionsFragment : Fragment() {
    private lateinit var binding: FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_instructions , container ,false)

        binding.startButton.setOnClickListener {
            navigateToShoeListFragment()
        }

        return binding.root
    }
    private fun navigateToShoeListFragment() {
        val action = InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
        findNavController().navigate(action)
    }
}