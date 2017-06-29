package com.bravo.gank.ui.fragment.history

import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.FragmentScope
import dagger.Component

/**
 * Created by Administrator on 2017/6/29.
 */
@FragmentScope
@Component(modules = arrayOf(HistoryModule::class),dependencies = arrayOf(AppComponent::class))
interface HistoryComponent{
   fun inject(historyFragment: HistoryFragment)
}