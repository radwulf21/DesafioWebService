package com.example.desafiowebservice.ui.activities.home

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desafiowebservice.domain.HQ
import com.example.desafiowebservice.service.Repository
import dmax.dialog.SpotsDialog
import kotlinx.coroutines.launch

class HomeViewModel(val repository: Repository) : ViewModel() {
    val HQ = MutableLiveData<HQ>()

    fun getHQ() {
        viewModelScope.launch {
            val hq = repository.getHQ(
                1,
                45,
                "1",
                "6eb7e8896ec5850c52515a8a23ee97f0",
                "40a3aa568bb269dfad85ae0c4a297181"
            )
            HQ.value = hq
        }
    }
}