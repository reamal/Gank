package com.bravo.gank.ui.fragment.welfare

import com.bravo.gank.base.AppComponent
import com.bravo.gank.data.source.DataSourceModule
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Component
import org.jetbrains.anko.appcompat.v7.Appcompat

/**
 * Created by Administrator on 2017/6/27.
 */
@FragmentScope
@Component(modules = arrayOf(WelfareModule::class),dependencies = arrayOf(AppComponent::class))
interface WelfareComponent {
    fun inject(fragment: WelfareFragment)
}