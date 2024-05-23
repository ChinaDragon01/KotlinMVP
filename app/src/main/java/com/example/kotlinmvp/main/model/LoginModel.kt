package com.example.kotlinmvp.main.model

import com.example.baselib.base.BaseModel
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse
import io.reactivex.rxjava3.core.Observable

/**
 *Author: chinadragonz
 *Time: 2024/5/19
 */
class LoginModel : BaseModel() {

    suspend fun login(parm: Map<String, Any>): ApiResponse<UserInfoBean?> {
        return apiCall { apiService.login(parm) }
    }

    suspend fun wxArticle(): ApiResponse<List<WXArticleBean>> {
        return apiCall { apiService.wxArticle() }
    }

    //演示使用rxjava3
    fun wxArticle2(): Observable<ApiResponse<List<WXArticleBean>?>> {
        return apiService.wxArticle2()
    }
}