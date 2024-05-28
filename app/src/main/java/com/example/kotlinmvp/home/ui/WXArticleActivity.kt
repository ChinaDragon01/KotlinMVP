package com.example.kotlinmvp.home.ui

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.baselib.base.BaseActivity
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.impl.NoMultiClickListener
import com.example.kotlinmvc.home.adpater.WXArticleAdapter
import com.example.kotlinmvp.databinding.ActivityWxarticleBinding
import com.example.kotlinmvp.home.contract.WXAritcelContract
import com.example.kotlinmvp.home.model.WXAritceModel
import com.example.kotlinmvp.home.presenter.WXAritcelPresenter
import com.example.kotlinmvp.main.ui.LoginActivity

/**
 *Author: chinadragon
 *Time: 2024/5/28
 */
class WXArticleActivity :
    BaseActivity<WXAritcelPresenter, WXAritceModel, ActivityWxarticleBinding>(),
    WXAritcelContract.WXAritcelView {
    private lateinit var wxArticleAdapter: WXArticleAdapter
    private lateinit var swipeRefresh: SwipeRefreshLayout
    override fun initViewBinding(): ActivityWxarticleBinding {
        return ActivityWxarticleBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mPresenter.attachModelView(mViewModel, this)
    }

    override fun initData() {
        swipeRefresh = binding.swipeRefresh
        wxArticleAdapter = WXArticleAdapter {

        }
        binding.rvData.apply {
            layoutManager = LinearLayoutManager(this@WXArticleActivity)
            adapter = wxArticleAdapter
        }
    }

    override fun loadData() {
        swipeRefresh.isRefreshing = true
        mPresenter.getWXArticel()
    }

    override fun initEvent() {
        swipeRefresh.setOnRefreshListener {
            loadData()
        }

        binding.tvLogin.setOnClickListener(NoMultiClickListener {
            startActivity(Intent(this@WXArticleActivity, LoginActivity::class.java))
            finish()
        })
    }

    override fun wxArticelSuccess(wxArticleBeanList: List<WXArticleBean>) {
        swipeRefresh.isRefreshing = false
        wxArticleAdapter.setData(wxArticleBeanList)
    }

    override fun showLoading(callBack: () -> Unit) {
    }

    override fun dismissLoading() {
    }
}