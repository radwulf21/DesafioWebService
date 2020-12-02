package com.example.desafiowebservice.ui.activities.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafiowebservice.R
import com.example.desafiowebservice.domain.HQ

class HomeViewModel : ViewModel() {
    val listHQ = MutableLiveData<ArrayList<HQ>>()

    fun fillListHQ() {
        val hq1 = HQ(R.drawable.spidey, "#95")
        val hq2 = HQ(R.drawable.spidey, "#95")
        val hq3 = HQ(R.drawable.spidey, "#95")
        val hq4 = HQ(R.drawable.spidey, "#95")

        listHQ.value = arrayListOf(hq1, hq2, hq3, hq4)
    }
}