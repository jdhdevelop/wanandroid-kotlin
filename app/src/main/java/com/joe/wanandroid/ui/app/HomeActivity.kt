package com.joe.wanandroid.ui.app

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.joe.wanandroid.R
import com.joe.wanandroid.base.CommonActivity
import com.joe.wanandroid.demo.SimpleWorker
import com.joe.wanandroid.model.BannerData
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_home.*
import java.util.concurrent.TimeUnit

class HomeActivity : CommonActivity() {

    private val bannerList: ArrayList<BannerData> = ArrayList()

    private lateinit var viewModel:HomeViewModel

    private lateinit var sp: SharedPreferences

    override fun getLayoutId(): Int = R.layout.activity_home

    override fun initView() {
//        bannerHome.setAdapter(object: BannerImageAdapter<BannerData>(bannerList){
//            override fun onBindView(
//                holder: BannerImageHolder?,
//                data: BannerData?,
//                position: Int,
//                size: Int
//            ) {
//                if (data != null) {
//                    holder?.let {
//                        Glide.with(holder.itemView)
//                            .load(data.imagePath)
//                            .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
//                            .into(holder.imageView)
//                    }
//                }
//            }
//        } as Nothing?)//这里需要as Nothing？ 才能消除错误，不知道该怎么写
//            .addBannerLifecycleObserver(this)
//            .indicator = CircleIndicator(this)
    }

    override fun initData(savedInstanceState: Bundle?) {
        sp = getSharedPreferences("wanAndroid_sp",Context.MODE_PRIVATE)
        val countReserved  = sp.getInt("count_reserved",0)
        viewModel = ViewModelProvider(this,HomeViewModelFactory(countReserved))
            .get(HomeViewModel::class.java)
        btnPlus.setOnClickListener {
            viewModel.plusOne()
        }
        btnClean.setOnClickListener {
            viewModel.clear()
        }
        lifecycle.addObserver(MyObserver(lifecycle))
//        viewModel.counter.observe(this, Observer { count ->
//            textView.text = count.toString()
//        })
        //专门为kotlin设计的ktx扩展写法
        viewModel.counter.observe(this){count ->
            textView.text = count.toString()
        }
        btnGetUser.setOnClickListener {
            val userId = (0..10000).random().toString()
            viewModel.getUser(userId)
        }
        viewModel.user.observe(this){user ->
            textView.text = user.firstName
        }
        btnDoWork.setOnClickListener {
            val request = OneTimeWorkRequest.Builder(SimpleWorker::class.java)
                .setInitialDelay(5, TimeUnit.MINUTES)
                .addTag("simple")
                .build()
            WorkManager.getInstance(this).enqueue(request)
        }
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved",viewModel.counter.value ?:0)
        }
    }

}