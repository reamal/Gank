package com.bravo.gank.base

import com.bravo.gank.data.DataManager
import com.bravo.gank.data.source.DataSourceModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Administrator on 2017/6/27.
 */

@Singleton
@Component(modules = arrayOf(DataSourceModule::class))
interface AppComponent{
    fun dataManager():DataManager
}