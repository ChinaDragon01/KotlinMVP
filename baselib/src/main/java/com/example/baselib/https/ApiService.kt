package com.example.baselib.https

import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.constant.HttpsConstant
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
interface ApiService {
    @POST(HttpsConstant.LOGIN)
    suspend fun login(@Body parm: Map<String, Any>): ApiResponse<UserInfoBean?>

    @GET(HttpsConstant.WX_ARTICLE)
    suspend fun wxArticle(): ApiResponse<List<WXArticleBean>>
}