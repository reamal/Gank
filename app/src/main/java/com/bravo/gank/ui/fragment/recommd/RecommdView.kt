package com.bravo.gank.ui.fragment.recommd

import com.bravo.gank.data.Article
import com.bravo.gank.ui.fragment.IViews

/**
 * Created by Administrator on 2017/6/29.
 */
interface RecommdView :IViews{
    fun  setUpView(parseRsult: List<Article>?)
    fun  setWelfImage(imageUrl: String)
}