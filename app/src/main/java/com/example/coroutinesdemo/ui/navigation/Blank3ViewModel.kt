package com.example.coroutinesdemo.ui.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.coroutinesdemo.base.BaseViewModel
import com.example.coroutinesdemo.data.db.entity.TestBean
import com.example.coroutinesdemo.data.repository.Blank3Repository

class Blank3ViewModel(private val mRepository: Blank3Repository) : BaseViewModel() {

    fun getTestBeans(): LiveData<PagingData<TestBean>> {
        return mRepository.getTestDatas().cachedIn(viewModelScope).asLiveData()
    }

}

