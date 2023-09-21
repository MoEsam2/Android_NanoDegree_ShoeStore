package com.example.android_nanodegree_shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.android_nanodegree_shoestore.R
import com.example.android_nanodegree_shoestore.databinding.FragmentShoeListBinding
import com.example.android_nanodegree_shoestore.viewmodel.ShoeViewModel
import kotlinx.android.synthetic.main.item_shoe.view.textView

class ShoeListFragment : Fragment(), MenuProvider {

    private val viewModel: ShoeViewModel by activityViewModels()
    private val binding by lazy {
        FragmentShoeListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.removeAllViews()
            for (shoe in it) {
                addShoe(shoe.name)
            }
        }
        binding.addShoeButton.setOnClickListener {
            navigateToShoeDetailFragment()
        }

        return binding.root
    }


    private fun addShoe(shoeName: String) {
        val view = layoutInflater.inflate(R.layout.item_shoe, null)
        view.textView.text = shoeName
        binding.shoeList.addView(view.textView)
    }

    private fun navigateToShoeDetailFragment() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
        findNavController().navigate(action)
    }

    private fun navigateToLoginFragment() {
        val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
        findNavController().navigate(action)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.menu_shoe_list, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when (menuItem.itemId) {
            R.id.action_logout -> {
                navigateToLoginFragment()
                true
            }

            else -> false

        }

    }
}