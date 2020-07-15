package com.example.coroutinesdemo.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coroutinesdemo.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    val userName = MutableLiveData<String>("")
    val passWord = MutableLiveData<String>("")

    private val _uiState = MutableLiveData<LoginUiState<User>>()
    val uiState: LiveData<LoginUiState<User>>
        get() = _uiState

    fun login() {
        Log.e("HomeViewModel", "login")
    }

    private fun isInputValid(userName: String, passWord: String): Boolean =
        userName.isNotBlank() && passWord.isNotBlank()

    val verifyInput: (String) -> Unit = {
        _uiState.value = LoginUiState(
            enableLoginButton = isInputValid(
                userName.value
                    ?: "", passWord.value ?: ""
            )
        )
    }

}

class LoginUiState<T>(
    isLoading: Boolean = false,
    isSuccess: T? = null,
    isError: String? = null,
    val enableLoginButton: Boolean = false
)