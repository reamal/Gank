package com.bravo.gank.ui.fragment.articles.pages

import com.bravo.gank.data.Type
import com.bravo.gank.ui.fragment.articles.pages.base.ArticlesFragment

/**
 * Created by Administrator on 2017/7/1.
 */
class VideoFragmet :ArticlesFragment(){

    companion object {
        fun newInstance():VideoFragmet {
            return VideoFragmet()
        }
    }

    override fun getType(): String {
       return Type.休息视频.name
    }
}