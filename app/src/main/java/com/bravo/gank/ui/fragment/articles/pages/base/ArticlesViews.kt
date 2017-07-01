package com.bravo.gank.ui.fragment.articles.pages.base

import com.bravo.gank.data.Article
import com.bravo.gank.ui.fragment.IViews

/**
 * Created by Administrator on 2017/6/29.
 */
interface ArticlesViews : IViews {
    fun  showResult(results: List<Article>)
}