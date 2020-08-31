package com.joe.wanandroid.model

/**
 * {
"data": ...,
"errorCode": 0, 0 代表成功，-1001 代表登录失败
"errorMsg": ""
}
 */
data class BaseResponse<T>(
    var data: T,
    var errorCode: Int,
    var errorMsg: String
)