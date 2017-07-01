package com.bravo.gank.ui.fragment.recommd

import com.bravo.gank.R
import com.bravo.gank.data.DataManager
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/6/29.
 */

@Module
class RecommdModules (val recommdView: RecommdFragment){

    @Provides
    fun providesRecommdPersenter(dataManager: DataManager):RecommdPersenter{
        return RecommdPersenter(recommdView,dataManager)
    }

    @Provides
    fun providesRecommendAdapter():RecommendAdapter{
        return RecommendAdapter(R.layout.item_recommend, arrayListOf())
    }
}