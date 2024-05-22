package com.example.baselib.base

/**
 *Author: chinadragon
 *Time: 2024/5/6
 */
open interface BaseView {

    fun showLoading(callBack: () -> Unit)

    fun dismissLoading()
}