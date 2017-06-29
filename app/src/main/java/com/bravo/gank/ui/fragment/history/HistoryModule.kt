package com.bravo.gank.ui.fragment.history

import com.bravo.gank.R
import com.bravo.gank.data.DataManager
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/6/29.
 */
@Module
class HistoryModule(val historyView : HistoryFragment) {
    @FragmentScope
    @Provides
    fun providesPersenter(dataManager:DataManager):HistoryPersenter{
        return HistoryPersenter(historyView,dataManager)
    }

    @FragmentScope
    @Provides
    fun providesHistoryAdapter():HistoryAdapter{
        return HistoryAdapter(historyView.activity, R.layout.item_history)
    }
}