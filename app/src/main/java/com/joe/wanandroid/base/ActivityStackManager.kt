package com.joe.wanandroid.base

import android.app.Activity


object ActivityStackManager {

    private val activities = mutableListOf<Activity>()

    fun addActivity(activity: Activity) = activities.add(activity)

    fun removeActivity(activity: Activity) {
        if (activities.contains(activity)) {
            activities.remove(activity)
            activity.finish()
        }
    }

    fun getTopActivity() {
        if (activities.isEmpty()) null else activities[activities.size -1]
    }

    fun finishAll() =
        activities.filterNot { it.isFinishing }.forEach { it.finish() }

}