package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingScreenBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.viewmodel.ShoeViewModel
import timber.log.Timber

class ListingScreen : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: ListingScreenBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.listing_screen, container, false
        )

        binding.addFAB.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_listingScreen_to_detailScreen)
        }

        setHasOptionsMenu(true)

        val shoeViewModel: ShoeViewModel by activityViewModels()
        val args = ListingScreenArgs.fromBundle(requireArguments())

        args.shoe?.let { shoeViewModel.addShoe(it) }

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoes ->
            for (shoe in shoes) {
                Timber.tag("MAIN").i(shoe.name)
                var viewItem = ShoeItemBinding.inflate(layoutInflater)
                viewItem.shoeItem = shoe
                binding.listLayout.addView(viewItem.root)
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.appmenu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.logoutBtnMenu) {
            Navigation.findNavController(requireView())
                .navigate(R.id.action_listingScreen_to_loginScreen)
        }
        return true
    }
}