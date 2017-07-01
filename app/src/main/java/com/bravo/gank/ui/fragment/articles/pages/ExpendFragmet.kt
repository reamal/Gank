package com.bravo.gank.ui.fragment.articles.pages

import com.bravo.gank.data.Type
import com.bravo.gank.ui.fragment.articles.pages.base.ArticlesFragment

/**
 * Created by Administrator on 2017/7/1.
 */
class ExpendFragmet  : ArticlesFragment(){

    companion object {
        fun newInstance():ExpendFragmet {
            return ExpendFragmet()
        }
    }

    override fun getType(): String {
        return Type.拓展资源.name
    }
}