package com.udacity.shoestore.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailScreensBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodel.ShoeViewModel


class DetailScreens : Fragment() {

    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: DetailScreensBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_screens, container, false
        )

        binding.lifecycleOwner = this
        binding.shoe = Shoe()

        binding.addBtn.setOnClickListener {
            addShoe(it, binding)
        }

        binding.cancelBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_detailScreens_to_listingScreen)
        }

        return binding.root
    }

    private fun addShoe(view: View, binding: DetailScreensBinding) {
        if (binding.nameEditText.text.isEmpty() || binding.sizeEditText.text.isEmpty()) {
            Toast.makeText(context, "required name and size field", Toast.LENGTH_SHORT).show()
        } else {
            val action = DetailScreensDirections.actionDetailScreensToListingScreen()
            binding.shoe?.let { shoeViewModel.addShoe(it) }
            Navigation.findNavController(view).navigate(action)
        }

    }
}