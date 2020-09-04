package com.joe.wanandroid.data

import androidx.lifecycle.liveData
import com.joe.wanandroid.http.WanAndroidNetWork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.coroutines.CoroutineContext

object Repository {

    fun getBanner() = fire(Dispatchers.IO) {
        coroutineScope {
            val banner = async {
                WanAndroidNetWork.getBanner()
            }
            val bannerResponse = banner.await()
            if (bannerResponse.errorCode == 0) {
                Result.success(bannerResponse.data)
            }else {
                Result.failure(RuntimeException(
                    "bannerResponse message is ${bannerResponse.errorMsg}"
                ))
            }

        }
    }

    private fun <T> fire(context: CoroutineContext, block: suspend () -> Result<T>) =
        liveData<Result<T>>(context) {
            val result = try {
                block()
            } catch (e: Exception) {
                Result.failure<T>(e)
            }
            emit(result)
        }
}