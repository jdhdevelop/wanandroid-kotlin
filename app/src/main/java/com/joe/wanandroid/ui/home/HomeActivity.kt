package com.joe.wanandroid.ui.home

import android.content.SharedPreferences
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joe.wanandroid.R
import com.joe.wanandroid.base.CommonActivity
import com.joe.wanandroid.model.BannerData
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : CommonActivity() {


    private lateinit var viewModel:HomeViewModel

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {
//        bannerHome.setAdapter(object: BannerImageAdapter<BannerData>(bannerList){
//            override fun onBindView(
//                holder: BannerImageHolder?,
//                data: BannerData?,
//                position: Int,
//                size: Int
//            ) {
//                if (data != null) {
//                    holder?.let {
//                        Glide.with(holder.itemView)
//                            .load(data.imagePath)
//                            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
//                            .into(holder.imageView)
//                    }
//                }
//            }
//        } as Nothing?)//这里需要as Nothing？ 才能消除错误，不知道该怎么写
//            .addBannerLifecycleObserver(this)
//            .indicator = CircleIndicator(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.bannerLiveData.observe(this) { result ->
            val bannerList = result.getOrNull()
            if (bannerList != null) {
                textView.text = bannerList.toString()
            }
        }
        btnGetBanner.setOnClickListener { viewModel.getBannerData() }
    }

    override fun onPause() {
        super.onPause()
    }

}