package com.example.coroutinesdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coroutinesdemo.base.BaseViewModel
import com.example.coroutinesdemo.model.bean.User
import com.example.coroutinesdemo.model.bean.checkResult
import com.example.coroutinesdemo.model.repository.LoginRepository

class HomeViewModel(private val repository: LoginRepository) : BaseViewModel() {

    val userName = MutableLiveData<String>("")
    val passWord = MutableLiveData<String>("")

    private val _uiState = MutableLiveData<LoginUiState<User>>()
    val uiState: LiveData<LoginUiState<User>>
        get() = _uiState

    fun login() {
        launchOnUI {
            _uiState.value = LoginUiState(isLoading = true)
            val result = repository.login(username = userName.value!!, password = passWord.value!!)
            result.checkResult(onSuccess = {
                _uiState.value = LoginUiState(isSuccess = it, enableLoginButton = true)
            }, onError = {
                _uiState.value = LoginUiState(isError = it, enableLoginButton = true)
            })

        }
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
    val isLoading: Boolean = false,
    val isSuccess: T? = null,
    val isError: String? = null,
    val enableLoginButton: Boolean = false
)