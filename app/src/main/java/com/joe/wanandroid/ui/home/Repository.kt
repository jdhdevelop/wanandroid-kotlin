package com.joe.wanandroid.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object Repository {
    fun getUser(userId: String): LiveData<User>{
        val liveData = MutableLiveData<User>()
        liveData.value = User(userId,userId,0)
        return liveData
    }
}

data class User(val firstName:String,val lastName:String,val age:Int)