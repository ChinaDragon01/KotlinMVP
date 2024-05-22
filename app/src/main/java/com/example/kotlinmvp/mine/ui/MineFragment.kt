package com.example.kotlinmvp.mine.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvp.databinding.FragmentMineBinding
import com.example.kotlinmvp.mine.contract.MineContract
import com.example.kotlinmvp.mine.model.MineModel
import com.example.kotlinmvp.mine.presenter.MinePresenter

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class MineFragment : BaseFragment<MinePresenter, MineModel, FragmentMineBinding>(),
    MineContract.MineView {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMineBinding {
        return FragmentMineBinding.inflate(inflater, container, false)
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