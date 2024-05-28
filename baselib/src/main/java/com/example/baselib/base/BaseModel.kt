package com.example.baselib.base

import com.example.baselib.https.ApiResponse
import com.example.baselib.https.ApiService
import com.example.baselib.https.RetrofitManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 *Author: chinadragon
 *Time: 2024/5/6
 */
open class BaseModel{
    companion object{
        val apiService by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            RetrofitManager.getService(
                ApiService::class.java
            )
        }
    }
    suspend fun <T> apiCall(api: suspend () -> ApiResponse<T>): ApiResponse<T> {
//        return withContext(Dispatchers.IO) { api.invoke() }
        return api.invoke()
    }
}