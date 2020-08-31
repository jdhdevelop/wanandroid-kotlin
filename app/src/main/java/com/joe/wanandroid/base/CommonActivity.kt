package com.joe.wanandroid.base

import android.os.Bundle

abstract class CommonActivity: BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun initData(savedInstanceState: Bundle?)

}