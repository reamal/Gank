package com.bravo.gank.ui.fragment.history

import android.content.Context
import com.bravo.gank.R
import com.bravo.gank.data.History
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by Administrator on 2017/6/29.
 */
class HistoryAdapter(val ctx: Context, layoutId:Int):BaseQuickAdapter<History,BaseViewHolder>(layoutId){
    override fun convert(helper: BaseViewHolder?, item: History?) {
        helper?.setText(R.id.content, "${item?.content}(${item?.date})")
    }

}