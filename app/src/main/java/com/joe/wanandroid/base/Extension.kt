package com.joe.wanandroid.base

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.joe.wanandroid.model.BaseResponse

/**
 * 自定义扩展函数API
 */


fun Context.stringValue(@StringRes stringRes: Int) = resources.getString(stringRes)

fun Context.drawableValue(@DrawableRes drawableRes: Int) = ContextCompat.getDrawable(this,drawableRes)

suspend fun <T> BaseResponse<T>.handleResult(
    fail: suspend (String) -> Unit = {BaseApplication.context.toast(it)},
    ok: suspend(T) -> Unit ={}
) {
    if (errorCode == 0) ok(data)
    else fail(errorMsg)
}