package com.bravo.gank.base

import android.app.Application
import com.bravo.gank.data.source.DataSourceModule

/**
 * Created by Administrator on 2017/6/26.
 */
class BaseApp : Application() {

    lateinit var component: AppComponent

    companion object {
        lateinit var instance: BaseApp
        fun getApp(): BaseApp {
            return this.instance
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerAppComponent.builder().dataSourceModule(DataSourceModule()).build()
    }

    fun getAppComponent():AppComponent{
        return component
    }
}