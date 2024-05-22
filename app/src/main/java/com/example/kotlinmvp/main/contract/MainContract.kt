package com.example.kotlinmvp.main.contract

import com.example.baselib.base.BasePresenter
import com.example.baselib.base.BaseView
import com.example.kotlinmvp.main.model.MainModel

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
interface MainContract {
    interface MainView : BaseView {}
    abstract class Presenter : BasePresenter<MainModel, MainView>() {}
}