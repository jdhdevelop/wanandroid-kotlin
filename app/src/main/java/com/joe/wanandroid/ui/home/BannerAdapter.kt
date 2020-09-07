package com.joe.wanandroid.ui.home

import android.util.Log
import com.bumptech.glide.Glide
import com.joe.wanandroid.base.BaseApplication
import com.joe.wanandroid.model.BannerData
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder

class BannerAdapter(bannerList: MutableList<BannerData>): BannerImageAdapter<BannerData>(bannerList) {
    override fun onBindView(
        holder: BannerImageHolder?,
        data: BannerData?,
        position: Int,
        size: Int
    ) {
        holder?.imageView?.let {
            Log.d("joe","进入glide ${data?.imagePath}")
            Glide.with(holder.itemView)
                .load(data?.imagePath)
                .into(it)
        }
    }
}