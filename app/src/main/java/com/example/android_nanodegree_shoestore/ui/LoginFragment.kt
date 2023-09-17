package com.example.android_nanodegree_shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android_nanodegree_shoestore.R
import com.example.android_nanodegree_shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.loginButton.setOnClickListener {
            navigateToWelcomeFragment()
        }
        binding.signUpButton.setOnClickListener {
            navigateToWelcomeFragment()
        }
        return binding.root
    }

    private fun navigateToWelcomeFragment() {
        val action = LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
        findNavController().navigate(action)
    }
}