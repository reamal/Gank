package com.bravo.gank.ui.fragment.articles.pages

import com.bravo.gank.data.Type
import com.bravo.gank.ui.fragment.articles.pages.base.ArticlesFragment

/**
 * Created by Administrator on 2017/7/1.
 */
class WebFragmet : ArticlesFragment(){

    companion object {
        fun newInstance():WebFragmet {
            return WebFragmet()
        }
    }

    override fun getType(): String {
        return Type.前端.name
    }
}