package com.bravo.gank.ui.fragment.articles

import com.bravo.gank.data.DataManager
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Module
import dagger.Provides

/**
 * Created by Administrator on 2017/6/29.
 */
@Module
class ArticlesModule(val articlesViews: ArticlesFragment) {


    @FragmentScope
    @Provides
    fun providesPersenter(dataManager: DataManager):ArticlesPersenter{
        return ArticlesPersenter(articlesViews,dataManager)
    }
}