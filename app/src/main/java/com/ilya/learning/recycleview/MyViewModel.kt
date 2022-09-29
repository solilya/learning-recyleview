package com.ilya.learning.recycleview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    val mutableLiveData : MutableLiveData<ArrayList<Persons>?> = MutableLiveData()

}