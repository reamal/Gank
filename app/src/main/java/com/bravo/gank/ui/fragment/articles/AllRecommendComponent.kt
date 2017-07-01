package com.bravo.gank.ui.fragment.articles

import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Component

/**
 * Created by Administrator on 2017/7/1.
 */
@FragmentScope
@Component(modules = arrayOf(AllRecommendModule::class),dependencies = arrayOf(AppComponent::class))
interface AllRecommendComponent {
    fun inject(allRecommendFragment: AllRecommendFragment)
}