package com.joe.wanandroid.demo

import android.os.Bundle
import android.util.Log
import com.joe.wanandroid.R
import com.joe.wanandroid.base.CommonActivity
import com.joe.wanandroid.http.ServiceCreator
import com.joe.wanandroid.util.await
import kotlinx.android.synthetic.main.activity_demo.*
import kotlinx.coroutines.*

class DemoActivity : CommonActivity() {
    override fun getLayoutId(): Int = R.layout.activity_demo

    override fun initView() {

    }

    override fun initData(savedInstanceState: Bundle?) {
        btn_request.setOnClickListener {
        }
    }


}