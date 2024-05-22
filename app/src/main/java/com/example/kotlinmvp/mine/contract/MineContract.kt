package com.example.kotlinmvp.mine.contract

import com.example.baselib.base.BasePresenter
import com.example.baselib.base.BaseView
import com.example.kotlinmvp.mine.model.MineModel

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
interface MineContract {
    interface MineView : BaseView {
    }

    abstract class Presenter : BasePresenter<MineModel, MineView>(){

    }

}