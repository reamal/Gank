package com.bravo.gank.ui.fragment.articles.pages.base

import com.bravo.gank.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/6/29.
 */
class ArticlesPersenter(val articlesViews: ArticlesViews, val dataManager: DataManager) {
    val PAGE_SIZE = 20;
    var pageNumber = 0;
    fun  getData(type: String) {
        dataManager.getDatas(type,PAGE_SIZE,pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    articlesViews.showResult(it.results)
                }
    }

    fun  loadMore(type: String) {
        pageNumber++
        getData(type)
    }

}