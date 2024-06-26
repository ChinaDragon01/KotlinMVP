package com.example.kotlinmvp.main.model

import com.example.baselib.base.BaseModel
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.https.ApiResponse

/**
 *Author: chinadragonz
 *Time: 2024/5/19
 */
class LoginModel : BaseModel() {

    suspend fun login(parm: Map<String, Any>): ApiResponse<UserInfoBean?> {
        return apiCall { apiService.login(parm) }
    }
}