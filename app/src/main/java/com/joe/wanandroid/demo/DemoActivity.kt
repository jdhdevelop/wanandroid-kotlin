package com.joe.wanandroid.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joe.wanandroid.R
import com.joe.wanandroid.base.CommonActivity
import com.joe.wanandroid.http.RetrofitManager
import com.joe.wanandroid.util.await
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.coroutines.*

class DemoActivity : CommonActivity() {
    override fun getLayoutId(): Int = R.layout.activity_demo

    override fun initView() {

    }

    override fun initData(savedInstanceState: Bundle?) {
        btn_request.setOnClickListener {
            val job = Job()
            CoroutineScope(job).launch {
                withContext(Dispatchers.IO){
                    getBannerData()
                }
            }
        }
    }

    private suspend fun getBannerData() {
        try {
            val bannerDataList = RetrofitManager.apiService.getBannerData().await()
            Log.e("coroutine",bannerDataList.toString())
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}