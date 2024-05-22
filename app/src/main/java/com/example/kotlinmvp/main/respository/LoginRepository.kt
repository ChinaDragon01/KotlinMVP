package com.example.kotlinmvp.main.respository

import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class LoginRepository : BaseRepository() {

    suspend fun login(parm: Map<String, Any>): ApiResponse<UserInfoBean?> {
        return apiCall { apiService.login(parm) }
    }

    suspend fun wxArticle(): ApiResponse<List<WXArticleBean>> {
        return apiCall { apiService.wxArticle() }
    }
}