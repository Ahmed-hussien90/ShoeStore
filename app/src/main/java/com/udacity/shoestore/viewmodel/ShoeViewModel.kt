package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private var shoe1 = Shoe(
        "shoe 1",
        43.5,
        "nike",
        "nike shoe1"
    )
    private var shoe2 = Shoe(
        "shoe 2",
        50.2,
        "nike",
        "nike shoe2"
    )

    private var _shoeList: MutableLiveData<ArrayList<Shoe>> =
        MutableLiveData(arrayListOf(shoe1, shoe2))

    val shoeList: LiveData<ArrayList<Shoe>>
        get() = _shoeList


    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }


}