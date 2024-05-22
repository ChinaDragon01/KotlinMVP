package com.example.kotlinmvp.main.presenter

import com.example.baselib.https.ApiErrorInfo
import com.example.kotlinmvp.main.contract.LoginContract

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
class LoginPresenter : LoginContract.Presenter() {


    override fun login(userName: String, pwd: String) {
        val map = mapOf("username" to userName, "password" to pwd)
        launchApiCall({ mModel.login(map) }, {

        }, {

        })
    }

    override fun getWXArticel() {
        launchApiCall({ mModel.wxArticle() }, successCallBack = {
            if (it.data == null) {
                return@launchApiCall
            }
            getView().wxArticelSuccess(it.data!!)
        }, errorCallBack = {

        }, exceptionCallBack = {

        })


    }
}