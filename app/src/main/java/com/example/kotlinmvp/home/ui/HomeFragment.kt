package com.example.kotlinmvp.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.baselib.base.BaseFragment
import com.example.kotlinmvp.databinding.FragmentHomeBinding
import com.example.kotlinmvp.home.contract.HomeContract
import com.example.kotlinmvp.home.model.HomeModel
import com.example.kotlinmvp.home.presenter.HomePresenter

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class HomeFragment : BaseFragment<HomePresenter, HomeModel, FragmentHomeBinding>(),
    HomeContract.HomeView {
    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun initData() {
        super.initData()
        mPresenter.attachModelView(mViewModel, this)
    }

    companion object {
        fun creatHomeFragment(bundle: Bundle = Bundle()): HomeFragment {
            var bundle = Bundle()
            return HomeFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun showLoading(callBack: () -> Unit) {
    }

    override fun dismissLoading() {
    }
}