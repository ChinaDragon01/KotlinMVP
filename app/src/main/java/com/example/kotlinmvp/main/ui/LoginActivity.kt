package com.example.kotlinmvp.main.ui

import android.content.Intent
import android.os.Bundle
import com.example.baselib.base.BaseActivity
import com.example.baselib.bean.UserInfoBean
import com.example.baselib.bean.WXArticleBean
import com.example.baselib.https.ApiErrorInfo
import com.example.baselib.impl.NoMultiClickListener
import com.example.baselib.utils.ToastUtil
import com.example.kotlinmvp.databinding.ActivityLoginBinding
import com.example.kotlinmvp.main.contract.LoginContract
import com.example.kotlinmvp.main.model.LoginModel
import com.example.kotlinmvp.main.presenter.LoginPresenter

/**
 *Author: chinadragon
 *Time: 2024/5/19
 */
class LoginActivity : BaseActivity<LoginPresenter, LoginModel, ActivityLoginBinding>(), LoginContract.LoginView {
    override fun initViewBinding(): ActivityLoginBinding {
        return ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        super.initView(savedInstanceState)
        mPresenter.attachModelView(mViewModel,this)
    }

    override fun initData() {
        super.initData()
    }

    override fun initEvent() {
        super.initEvent()
        with(binding) {
            btnLogin.setOnClickListener(NoMultiClickListener {
//                mPresenter.login("","")
                mPresenter.getWXArticel()
            })
        }
    }

    override fun loginSuccess(userInfoBean: UserInfoBean) {
//        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun loginFail(apiErrorInfo: ApiErrorInfo) {
        ToastUtil.show("登录失败")
    }

    override fun wxArticelSuccess(wxArticleBeanList: List<WXArticleBean>) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }

    override fun showLoading(callBack: () -> Unit) {
        ToastUtil.show("加载中...")

    }

    override fun dismissLoading() {

    }

}