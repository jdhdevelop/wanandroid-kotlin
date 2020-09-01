package com.joe.wanandroid.ui.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class HomeViewModel(countReserved: Int): ViewModel() {
    //对外暴露只读的变量，写操作交给自己内部，保证数据的封装性
    val counter: LiveData<Int>
        get() = _counter

    private val _counter = MutableLiveData<Int>()

    private val userIdLiveData = MutableLiveData<String>()

    val user: LiveData<User> = Transformations.switchMap(userIdLiveData){userId ->
        Repository.getUser(userId)
    }

    init {
        _counter.value = countReserved
    }

    fun plusOne() {
        val count = _counter.value ?:0
        _counter.value = count + 1
    }

    fun clear() {
        _counter.value = 0
    }

    fun getUser(userId: String) {
        userIdLiveData.value = userId
    }

}