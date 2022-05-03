package com.a.luxurycar.common.application;

import android.app.Application
import android.content.Context


class LuxuryCarApplication : Application() {
    private var activityInForeground: Boolean = false

    private val mInstance: LuxuryCarApplication? = null


    override fun onCreate() {
        super.onCreate()

        instance = this
        application = this

     //   TypeFaceUtil.setDefaultFont(this, "MONOSPACE", "font/Manrope-Regular.ttf")

    }

    @Synchronized
    fun getInstance(): LuxuryCarApplication {
        return mInstance!!
    }



    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    companion object {

        private var activityVisible: Boolean = false

        lateinit var application: Application

        var instance: Context? = null
            private set
    }
}