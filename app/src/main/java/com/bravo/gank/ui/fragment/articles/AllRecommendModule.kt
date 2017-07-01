package com.bravo.gank.ui.fragment.articles

import com.bravo.gank.data.DataManager
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/7/1.
 */
@Module
class AllRecommendModule(val allRecommendViews: AllRecommendFragment) {

    @Provides
    fun providesAllRecommendPersenter(dataManager: DataManager):AllRecommendPersenter{
      return  AllRecommendPersenter(allRecommendViews,dataManager)
    }
}