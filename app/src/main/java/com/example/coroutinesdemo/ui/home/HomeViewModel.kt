package com.example.coroutinesdemo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.coroutinesdemo.base.BaseViewModel
import com.example.coroutinesdemo.model.api.WanRetrofitClient
import com.example.coroutinesdemo.model.bean.User
import com.example.coroutinesdemo.util.MD5Util
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel : BaseViewModel() {

    val userName = MutableLiveData<String>("")
    val passWord = MutableLiveData<String>("")

    private val _uiState = MutableLiveData<LoginUiState<User>>()
    val uiState: LiveData<LoginUiState<User>>
        get() = _uiState

    fun login() {
        launchOnUI {
            try {
                val map = HashMap<String, String?>()
                map["username"] = userName.value
                map["password"] = MD5Util.encode(passWord.value!!)
                map["grant_type"] = "password"
                val data = withContext(Dispatchers.IO) {
                    WanRetrofitClient.service.login(map)
                }
                if (data != null) {
                    _uiState.value = LoginUiState(isSuccess = data, enableLoginButton = true)
                } else {
                    _uiState.value = LoginUiState(isError = "获取失败", enableLoginButton = true)
                }

            } catch (e: Exception) {
                /*请求异常的话在这里处理*/
                e.printStackTrace()
                _uiState.value = LoginUiState(isError = e.message, enableLoginButton = true)
            }
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