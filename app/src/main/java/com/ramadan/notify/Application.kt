package com.ramadan.notify

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class Application : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: Application? = null
        fun getAppContext(): Context {
            return instance!!.applicationContext
        }
    }

}