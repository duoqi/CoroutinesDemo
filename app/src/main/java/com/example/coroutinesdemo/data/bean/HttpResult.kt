package com.example.coroutinesdemo.data.bean

sealed class HttpResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : HttpResult<T>()
    data class Error(val exception: Exception) : HttpResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
        }
    }
}

inline fun <T : Any> HttpResult<T>.checkResult(crossinline onSuccess: (T) -> Unit,crossinline onError: (String?) -> Unit) {
    if (this is HttpResult.Success) {
        onSuccess(data)
    } else if (this is HttpResult.Error) {
        onError(exception.message)
    }
}