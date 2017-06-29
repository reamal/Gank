package com.bravo.gank.ui.fragment.history

import com.bravo.gank.data.History
import com.bravo.gank.ui.fragment.IViews

/**
 * Created by Administrator on 2017/6/29.
 */
interface HistoryView :IViews{
    fun  showHistory(parseHtml: List<History>)
}