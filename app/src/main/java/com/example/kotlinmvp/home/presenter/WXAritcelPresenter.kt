package com.example.kotlinmvp.home.presenter

import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiResponse
import com.example.kotlinmvp.home.contract.WXAritcelContract
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
class WXAritcelPresenter : WXAritcelContract.Presenter() {
    override fun getWXArticel() {
        //方式一 retrofit2 + 协程
        launchApiCall({ mModel.wxArticle() }, successCallBack = {
            if (it.data == null) {
                return@launchApiCall
            }
            getView().wxArticelSuccess(it.data!!)
        }, errorCallBack = {

        }, exceptionCallBack = {

        })

        //方式二：retrofit2 + Rxjava3 + rxandroid
//        wrapObservable(mModel.wxArticle2()).subscribe(object :
//            Observer<ApiResponse<List<WXArticleBean>?>> {
//            override fun onSubscribe(d: Disposable) {
//                listDisposable.add(d)
//            }
//
//            override fun onError(e: Throwable) {
//            }
//
//            override fun onComplete() {
//            }
//
//            override fun onNext(response: ApiResponse<List<WXArticleBean>?>) {
//                if (response.data == null) {
//                    return
//                }
//                getView().wxArticelSuccess(response.data!!)
//            }
//
//        })

        //提醒，如果第二个接口请求参数需要从第一个接口返回的数据里取，可以使用 concatMap 进行组合请求
//        wrapObservable(mModel.getTempAccessToken().concatMap { autnBen ->
//            return@concatMap mModel.login(autnBen.accessToken)
//        }).subscribe(object : Observer<ApiResponse<UserInfoBean?>>{
//                override fun onSubscribe(d: Disposable) {
//                    listDisposable.add(d)
//                }
//
//                override fun onError(e: Throwable) {
//                }
//
//                override fun onComplete() {
//                }
//
//                override fun onNext(response: ApiResponse<UserInfoBean?>) {
//                    if (response.data == null) {
//                        return
//                    }
//                    getView().lgoinSuccess(response.data!!)
//                }
//
//            }
//        })

    }

}