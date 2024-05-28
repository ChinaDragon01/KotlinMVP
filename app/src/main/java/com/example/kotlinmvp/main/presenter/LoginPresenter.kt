package com.example.kotlinmvp.main.presenter

import com.example.baselib.bean.UserInfoBean
import com.example.kotlinmvp.main.contract.LoginContract
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
class LoginPresenter : LoginContract.Presenter() {


    override fun login(userName: String, pwd: String) {
        //模拟登录成功
        CoroutineScope(Dispatchers.IO).launch {
            delay(400)
            withContext(Dispatchers.Main){
                getView().loginSuccess(UserInfoBean("", "", ""))

            }

        }

        val map = mapOf("username" to userName, "password" to pwd)
        launchApiCall({ mModel.login(map) }, {
            if (it.data == null){
                return@launchApiCall
            }
            getView().loginSuccess(it.data!!)
        }, {

        })
    }
}