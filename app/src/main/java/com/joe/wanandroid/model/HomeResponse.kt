package com.joe.wanandroid.model

data class HomeResponse(val status: String, val result: Result) {
    data class Result(val banner: BannerData)
    data class BannerData(
        var desc: String,
        var id: Int,
        var imagePath: String,
        var isVisible: Boolean,
        var order: Int,
        var title: String,
        var type: Int,
        var url: String
    )
}