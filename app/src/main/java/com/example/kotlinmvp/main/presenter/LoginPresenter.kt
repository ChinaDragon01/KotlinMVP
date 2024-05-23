package com.example.kotlinmvp.main.presenter

import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse
import com.example.kotlinmvp.main.contract.LoginContract
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

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
        //方式一 retrofit2 + 协程
//        launchApiCall({ mModel.wxArticle() }, successCallBack = {
//            if (it.data == null) {
//                return@launchApiCall
//            }
//            getView().wxArticelSuccess(it.data!!)
//        }, errorCallBack = {
//
//        }, exceptionCallBack = {
//
//        })

        //方式二：retrofit2 + Rxjava3 + rxandroid
        wrapObservable(mModel.wxArticle2()).subscribe(object :
            Observer<ApiResponse<List<WXArticleBean>?>> {
            override fun onSubscribe(d: Disposable) {
                listDisposable.add(d)
            }

            override fun onError(e: Throwable) {
            }

            override fun onComplete() {
            }

            override fun onNext(response: ApiResponse<List<WXArticleBean>?>) {
                if (response.data == null) {
                    return
                }
                getView().wxArticelSuccess(response.data!!)
            }

        })

    }
}