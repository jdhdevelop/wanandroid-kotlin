package com.joe.wanandroid.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joe.wanandroid.R
import com.joe.wanandroid.base.CommonActivity
import com.joe.wanandroid.model.BannerData
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : CommonActivity() {


    private val viewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java)}

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {

    }

    override fun initData(savedInstanceState: Bundle?) {
        viewModel.bannerLiveData.observe(this) { result ->
            val bannerList = result.getOrNull() as MutableList<BannerData>
            textView.text = bannerList.toString()
            bannerHome.apply {
                adapter = BannerAdapter(bannerList)
                addBannerLifecycleObserver(this@HomeActivity)
                indicator = CircleIndicator(this@HomeActivity)
            }
        }
        btnGetBanner.setOnClickListener {
            viewModel.refreshBanner()
        }
    }

    override fun onPause() {
        super.onPause()
    }

}