package com.joe.wanandroid.http

import com.joe.wanandroid.model.BannerData
import com.joe.wanandroid.model.BaseResponse
import com.joe.wanandroid.model.HomeListResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface Apis {

    /**
     * 首页数据
     */
    @GET("/article/list/{page}/json")
    fun getHomeList(@Path("page") page:Int):MutableList<HomeListResponse>

    @GET("/banner/json")
    fun getBannerData(): BaseResponse<MutableList<BannerData>>

}