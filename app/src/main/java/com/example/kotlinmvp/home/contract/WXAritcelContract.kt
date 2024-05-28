package com.example.kotlinmvp.home.contract

import com.example.baselib.base.BasePresenter
import com.example.baselib.base.BaseView
import com.example.baselib.bean.WXArticleBean
import com.example.kotlinmvp.home.model.WXAritceModel

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
interface WXAritcelContract {
    interface WXAritcelView : BaseView {
        fun wxArticelSuccess(wxArticleBeanList: List<WXArticleBean>)
    }

    abstract class Presenter : BasePresenter<WXAritceModel, WXAritcelView>() {
        abstract fun getWXArticel()
    }
}