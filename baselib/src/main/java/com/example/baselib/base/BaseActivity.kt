package com.example.baselib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.baselib.utils.GenericsUtil

/**
 *Author: chinadragon
 *Time: 2024/5/7
 */
abstract class BaseActivity<P : BasePresenter<*, *>, M : BaseModel, VB : ViewBinding> :
    AppCompatActivity() {
    protected lateinit var mViewModel: M
    protected lateinit var mPresenter: P
    protected lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        initBefore(savedInstanceState)
        super.onCreate(savedInstanceState)
        initContentView()
        initViewModel()
        initPresenter()
        initData()
        initView(savedInstanceState)
        loadData()
        initEvent()
    }

    private fun initContentView() {
        binding = initViewBinding()
        setContentView(binding.root)
    }



    private fun initViewModel() {
        mViewModel = GenericsUtil.getInstant(this, argIndex = 1)
    }

    private fun initPresenter() {
        mPresenter = GenericsUtil.getInstant(this, argIndex = 0)
    }

    abstract fun initViewBinding(): VB

    open fun initBefore(savedInstanceState: Bundle?) {

    }

    open fun initView(savedInstanceState: Bundle?) {

    }

    /**
     * Called before {@link #initView(savedInstanceState: Bundle?)}
     */
    open fun initData() {

    }

    open fun loadData() {

    }

    open fun initEvent() {

    }

    override fun onDestroy() {
        if (::mPresenter.isInitialized){
            mPresenter.dettachView()
            mPresenter.cancelAllJob()
        }

        super.onDestroy()
    }
}