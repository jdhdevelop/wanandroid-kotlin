package com.joe.wanandroid.ui

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.joe.wanandroid.R
import com.joe.wanandroid.base.CommonActivity
import com.joe.wanandroid.model.BannerData
import com.joe.wanandroid.model.BaseResponse
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : CommonActivity() {

    private val bannerList: ArrayList<BannerData> = ArrayList()

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {
        bannerHome.setAdapter(object: BannerImageAdapter<BannerData>(bannerList){
            override fun onBindView(
                holder: BannerImageHolder?,
                data: BannerData?,
                position: Int,
                size: Int
            ) {
                if (data != null) {
                    holder?.let {
                        Glide.with(holder.itemView)
                            .load(data.imagePath)
                            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                            .into(holder.imageView)
                    }
                }
            }
        } as Nothing?)//这里需要as Nothing？ 才能消除错误，不知道该怎么写
            .addBannerLifecycleObserver(this)
            .indicator = CircleIndicator(this)

    }

    override fun initData(savedInstanceState: Bundle?) {

    }


}