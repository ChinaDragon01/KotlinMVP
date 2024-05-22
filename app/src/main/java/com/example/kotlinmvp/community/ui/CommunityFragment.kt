package com.example.kotlinmvp.community.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvp.community.contract.CommunityContract
import com.example.kotlinmvp.community.model.CommunityModel
import com.example.kotlinmvp.community.presenter.CommunityPresenter
import com.example.kotlinmvp.databinding.FragmentCommunityBinding

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class CommunityFragment :
    BaseFragment<CommunityPresenter, CommunityModel, FragmentCommunityBinding>(),
    CommunityContract.CommunityView {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentCommunityBinding {
        return FragmentCommunityBinding.inflate(inflater, container, false)
    }

    override fun initData() {
        super.initData()
        mPresenter.attachModelView(mViewModel, this)
    }

    override fun showLoading(callBack: () -> Unit) {

    }

    override fun dismissLoading() {
    }
}