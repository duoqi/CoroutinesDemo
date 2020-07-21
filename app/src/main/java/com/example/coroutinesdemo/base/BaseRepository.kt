package com.example.coroutinesdemo.base

import com.example.coroutinesdemo.data.bean.HttpResult
import com.example.coroutinesdemo.data.bean.WanResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import retrofit2.HttpException
import java.io.IOException

open class BaseRepository {

    suspend fun <T : Any> safeApiCall(
        call: suspend () -> HttpResult<T>,
        errorMessage: String
    ): HttpResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            if (e is HttpException) {
                HttpResult.Error(IOException(e.code().toString(), e))
            } else {
                HttpResult.Error(IOException(errorMessage, e))
            }
        }
    }

    suspend fun <T : Any> executeResponse(
        response: WanResponse<T>, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): HttpResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                HttpResult.Error(IOException(response.errorMsg))
            } else {
                successBlock?.let { it() }
                HttpResult.Success(response.data)
            }
        }
    }

    suspend fun <T : Any> executeResponse(
        response: T?, successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): HttpResult<T> {
        return coroutineScope {
            if (response == null) {
                errorBlock?.let { it() }
                HttpResult.Error(exception = IOException())
            } else {
                successBlock?.let { it() }
                HttpResult.Success(response)
            }
        }
    }


}