package com.example.kotlinmvp.community.contract

import com.example.baselib.base.BasePresenter
import com.example.baselib.base.BaseView
import com.example.kotlinmvp.community.model.CommunityModel

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
interface CommunityContract {
    interface CommunityView : BaseView {
    }

    abstract class Presenter : BasePresenter<CommunityModel, CommunityView>(){

    }

}