package com.example.baselib.base

import com.example.baselib.constant.HttpsConstant
import com.example.baselib.https.ApiResponse
import com.example.baselib.utils.ToastUtil
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.ref.WeakReference

/**
 *Author: chinadragon
 *Time: 2024/5/22
 */
open class BasePresenter<M : BaseModel, V : BaseView> {
    protected lateinit var mModel: M

    //    protected lateinit var mView: V
    protected lateinit var mViewRef: WeakReference<V>

    protected val jobList = mutableListOf<Job>()

    fun cancelAllJob() {
        if (jobList.isEmpty()) {
            return
        }
        jobList.forEach {
            if (it.isActive) {
                it.cancel()
            }
        }
        jobList.clear()
    }


    open fun attachModelView(model: M, view: V) {
        mModel = model
        mViewRef = WeakReference(view)
    }

    open fun getView(): V {
        if (mViewRef.get() == null) {
            throw IllegalArgumentException("${javaClass.simpleName}  mViewRef value is null")

        }
        return mViewRef.get()!!
    }

    open fun dettachView() {
        if (::mViewRef.isInitialized) {
            mViewRef.clear()
        }

        if (listDisposable.isEmpty()) {
            return
        }
        listDisposable.forEach {
            it.dispose()
        }
        listDisposable.clear()
    }

    fun <T> launchApiCall(
        apiCall: suspend CoroutineScope.() -> ApiResponse<T>,
        successCallBack: suspend CoroutineScope.(response: ApiResponse<T>) -> Unit = {},
        errorCallBack: suspend CoroutineScope.(response: ApiResponse<T>) -> Unit = {},
        exceptionCallBack: suspend CoroutineScope.() -> Unit = {},
        showToast: Boolean = true,
    ) {
        /*
           注意：
           BaseModel 里的 apiCall 里面 使用了withContext(Dispatchers.IO)
           所以CoroutineScope的 context 可以指定为Dispatchers.Unconfined

           如果 BaseModel 里的 apiCall 里面 没有使用withContext(Dispatchers.IO)
           那么CoroutineScope的 context 需要指定为Dispatchers.IO

           这里指定为 Dispatchers.IO

           如果不明白，可以查阅关于调度器（Dispatchers）的使用
         */
        val job = CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiCall()
                withContext(Dispatchers.Main) {
                    if (response.errorCode == HttpsConstant.NET_SUCCESS) {
                        successCallBack(response)

                    } else {
                        errorCallBack(response)
                        if (showToast) {
                            ToastUtil.show(response.errorMsg)
                        }
                    }
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    exceptionCallBack()
                }

            }
        }
        if (job.isActive) {
            jobList.add(job)
        }
    }

    protected var listDisposable: MutableList<Disposable> = mutableListOf()
    protected open fun addDisposable(disposable: Disposable) {
        listDisposable.add(disposable)
    }

    //演示使用rxjava3
    protected open fun <T> wrapObservable(observable: Observable<ApiResponse<T?>>): Observable<ApiResponse<T?>> {
        return observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .unsubscribeOn(Schedulers.io())
    }
}