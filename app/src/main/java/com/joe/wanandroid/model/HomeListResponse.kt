package com.joe.wanandroid.model

data class HomeListResponse(
    var curPage: Int,
    var datas: MutableList<Data>,
    var offset: Int,
    var over: Boolean,
    var pageCount: Int,
    var size: Int,
    var total: Number
)

data class Data(
    var audit: Int,
    var author: String,
    var chapterId: Int,
    var chapterName: String,
    var collect: Boolean,
    var courseId: Int,
    var desc: String,
    var id: Long,
    var link: String,
    var superChapterId: Int,
    var superChapterName: String,
    var tags: MutableList<Tag>,
    var title: String,
    var type: Int,
    var userId: Int,
    var visiable: Int,
    var zan: Int
)

data class Tag(
    var name: String,
    var url: String
)