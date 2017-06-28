package com.bravo.gank.ui.fragment.welfare

import com.bravo.gank.data.Article
import com.bravo.gank.data.Result
import com.bravo.gank.ui.fragment.IViews

/**
 * Created by Administrator on 2017/6/27.
 */
interface WelfareViews :IViews{
    fun  showResult(it: List<Article>)
}