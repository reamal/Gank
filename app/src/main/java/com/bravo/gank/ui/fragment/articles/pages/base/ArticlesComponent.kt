package com.bravo.gank.ui.fragment.articles.pages.base

import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Component

/**
 * Created by Administrator on 2017/6/29.
 */
@FragmentScope
@Component(modules = arrayOf(ArticlesModule::class), dependencies = arrayOf(AppComponent::class))
interface ArticlesComponent {
    fun inject(articlesFragment: ArticlesFragment)
}