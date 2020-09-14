package com.joe.wanandroid.ui.home

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.joe.wanandroid.R
import com.joe.wanandroid.base.BaseActivity
import com.joe.wanandroid.databinding.ActivityHomeBinding
import com.joe.wanandroid.model.BannerData
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity<ActivityHomeBinding>() {


    private val viewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java)}

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initActivity(savedInstanceState: Bundle?) {
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



}