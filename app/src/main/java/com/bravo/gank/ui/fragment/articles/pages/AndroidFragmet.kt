package com.bravo.gank.ui.fragment.articles.pages

import com.bravo.gank.data.Type
import com.bravo.gank.ui.fragment.articles.pages.base.ArticlesFragment

/**
 * Created by Administrator on 2017/7/1.
 */
class AndroidFragmet : ArticlesFragment(){

    companion object {
        fun newInstance():AndroidFragmet {
            return AndroidFragmet()
        }
    }

    override fun getType(): String {
        return Type.Android.name
    }
}