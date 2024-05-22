package com.example.kotlinmvp.home.contract

import com.example.baselib.base.BasePresenter
import com.example.baselib.base.BaseView
import com.example.kotlinmvp.home.model.HomeModel

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
interface HomeContract {
    interface HomeView : BaseView {
    }

    abstract class Presenter : BasePresenter<HomeModel, HomeView>() {

    }

}