package com.bravo.gank.ui.fragment.articles.pages

import com.bravo.gank.data.Type
import com.bravo.gank.ui.fragment.articles.pages.base.ArticlesFragment

/**
 * Created by Administrator on 2017/7/1.
 */
class IOSFragmet : ArticlesFragment(){

    companion object {
        fun newInstance():IOSFragmet {
            return IOSFragmet()
        }
    }

    override fun getType(): String {
        return Type.iOS.name
    }
}