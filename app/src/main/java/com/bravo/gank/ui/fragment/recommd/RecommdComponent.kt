package com.bravo.gank.ui.fragment.recommd

import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Component

/**
 * Created by Administrator on 2017/6/30.
 */
@FragmentScope
@Component(modules = arrayOf(RecommdModules::class),dependencies = arrayOf(AppComponent::class))
interface RecommdComponent{
    fun inject(recommdFragment: RecommdFragment)
}