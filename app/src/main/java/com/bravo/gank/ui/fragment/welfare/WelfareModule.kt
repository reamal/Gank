package com.bravo.gank.ui.fragment.welfare

import com.bravo.gank.data.DataManager
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/6/27.
 */
@Module
class WelfareModule(val welfareViews: WelfareViews) {

    @FragmentScope
    @Provides
    fun provideWelfarePersenter(dataManager: DataManager):WelfarePersenter{
        return WelfarePersenter(welfareViews,dataManager)
    }
}