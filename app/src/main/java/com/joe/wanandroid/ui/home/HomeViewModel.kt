package com.joe.wanandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.joe.wanandroid.data.Repository
import com.joe.wanandroid.model.HomeResponse

class HomeViewModel: ViewModel() {


    private val refreshBanner = MutableLiveData<Any?>()

    val bannerLiveData = Transformations.switchMap(refreshBanner) {
        Repository.getBanner()
    }

    //请求没有参数时的空写法
    fun refreshBanner() {
        refreshBanner.value = refreshBanner.value
    }
}