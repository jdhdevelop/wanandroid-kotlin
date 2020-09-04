package com.joe.wanandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.joe.wanandroid.data.Repository
import com.joe.wanandroid.model.HomeResponse

class HomeViewModel(countReserved: Int): ViewModel() {

    private val banner = MutableLiveData<MutableList<HomeResponse.BannerData>>()

    val bannerLiveData = Transformations.switchMap(banner) {
        Repository.getBanner()
    }

    fun getBannerData() {
        Repository.getBanner()
    }
}