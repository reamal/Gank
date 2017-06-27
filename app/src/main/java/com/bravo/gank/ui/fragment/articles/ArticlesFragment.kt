package com.bravo.gank.ui.fragment.articles

import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.BaseFragment

/**
 * Created by Administrator on 2017/6/26.
 */
class ArticlesFragment: BaseFragment(){
    override fun attachLayoutId(): Int= R.layout.fragment_article_container

    companion object{
        fun newInstance(): ArticlesFragment {
            return ArticlesFragment()
        }
    }

    override fun initViews(view: View) {
    }

    override fun setUpComponent(appComponent: AppComponent) {
    }
}