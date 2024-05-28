package com.example.kotlinmvp.home.model

import com.example.baselib.base.BaseModel
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse
import io.reactivex.rxjava3.core.Observable

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
class WXAritceModel : BaseModel() {
    suspend fun wxArticle(): ApiResponse<List<WXArticleBean>> {
        return apiCall { apiService.wxArticle() }
    }

    //演示使用rxjava3
    fun wxArticle2(): Observable<ApiResponse<List<WXArticleBean>?>> {
        return apiService.wxArticle2()
    }
}