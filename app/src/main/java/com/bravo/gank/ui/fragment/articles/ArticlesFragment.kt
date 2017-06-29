package com.bravo.gank.ui.fragment.articles

import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.BaseFragment
import javax.inject.Inject

/**
 * Created by Administrator on 2017/6/26.
 */
class ArticlesFragment: BaseFragment(),ArticlesViews{
    override fun attachLayoutId(): Int= R.layout.fragment_article_container

    @Inject
    lateinit var articlesPersenter:ArticlesPersenter

    companion object{
        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }
    }

    override fun initViews(view: View?) {

    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerArticlesComponent.builder().appComponent(appComponent).articlesModule(ArticlesModule(this)).build().inject(this)
    }
}