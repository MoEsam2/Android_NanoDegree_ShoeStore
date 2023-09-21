package com.example.android_nanodegree_shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_nanodegree_shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList
    var newShoeName = ""
    var newShoeSize = ""
    var newCompanyName = ""
    var newShoeDescription = ""

    init {
        _shoeList.value = mutableListOf()
    }

    fun restNewShoe() {
        newShoeName = ""
        newShoeSize = ""
        newCompanyName = ""
        newShoeDescription = ""
    }

    fun addNewShoe(): Boolean {
        if (!validateNewShoeInputs()) return false
        else {
            addShoe(
                newShoeName, newShoeSize.toDouble(), newCompanyName, newShoeDescription
            )
        }
        return true
    }

    private fun addShoe(
        name: String,
        size: Double,
        company: String,
        description: String
    ) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value?.add(shoe)
    }

    private fun validateNewShoeInputs(): Boolean {
        return !(newShoeName.isBlank() ||
                newCompanyName.isBlank() ||
                newShoeDescription.isBlank() ||
                newShoeSize.isBlank())

    }
}