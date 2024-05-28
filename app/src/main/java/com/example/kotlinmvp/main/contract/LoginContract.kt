package com.example.kotlinmvp.main.contract

import com.example.baselib.base.BasePresenter
import com.example.baselib.base.BaseView
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiErrorInfo
import com.example.kotlinmvp.main.model.LoginModel

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
interface LoginContract {
    interface LoginView : BaseView {
        fun loginSuccess(userInfoBean: UserInfoBean)
        fun loginFail(apiErrorInfo: ApiErrorInfo)
    }

    abstract class Presenter : BasePresenter<LoginModel, LoginView>() {
        abstract fun login(userName: String, pwd: String)
    }
}