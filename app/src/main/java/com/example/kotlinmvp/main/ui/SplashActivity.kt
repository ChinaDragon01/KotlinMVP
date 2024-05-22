package com.example.kotlinmvp.main.ui

import android.content.Intent
import com.example.baselib.base.BaseActivity
import com.example.baselib.base.BaseEmptyModel
import com.example.baselib.base.BaseEmptyPresenter
import com.example.baselib.extension.countDown
import com.example.baselib.utils.LogUtil
import com.example.kotlinmvp.databinding.ActivitySplashBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

/**
 *Author: chinadragon
 *Time: 2024/5/20
 */
class SplashActivity : BaseActivity<BaseEmptyPresenter, BaseEmptyModel, ActivitySplashBinding>() {
    private var mCountDownJob: CoroutineScope? = null
    override fun initViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun initData() {
        super.initData()
        val second3 = 3
        this.countDown(time = second3, start = {
            binding.tvCountDown.setText("剩余 $second3 秒")
            mCountDownJob = it
        }, end = {
            LogUtil.i("SplashActivity", "倒计时结束了")
            //正式项目里需要判断用户是否已登录 TODO
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            finish()

        }, next = {
            LogUtil.i("SplashActivity", "剩余 $it 秒")
            binding.tvCountDown.setText("剩余 ${it - 1} 秒")

        }, error = {

        })
    }

    override fun onDestroy() {
        mCountDownJob?.let {
            it.cancel()
        }
        super.onDestroy()
    }
}