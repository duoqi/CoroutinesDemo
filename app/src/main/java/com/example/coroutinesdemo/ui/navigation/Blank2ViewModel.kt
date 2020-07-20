package com.example.coroutinesdemo.ui.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coroutinesdemo.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Blank2ViewModel : BaseViewModel() {

    private val _uiState = MutableLiveData<MutableList<String>>()
    val uiState: LiveData<MutableList<String>>
        get() = _uiState

    fun getData() {
        launchOnUI {
            val datas = mutableListOf<String>()
            for (i in 1..100) {
                datas.add(i.toString())
            }
            withContext(Dispatchers.IO) {
                delay(3000)
            }
            _uiState.value = datas
        }

    }

}