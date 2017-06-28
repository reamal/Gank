package com.bravo.gank.ui.fragment.welfare

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bravo.gank.R
import com.bravo.gank.data.Article
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder

/**
 * Created by Administrator on 2017/6/28.
 */
class WelfareAdapter(val ctx: Context,layoutId:Int) :BaseQuickAdapter<Article,BaseViewHolder> (layoutId){
    override fun convert(helper: BaseViewHolder?, item: Article?) {
        val imageView = helper?.getView<ImageView>(R.id.image)
        Glide.with(ctx).load(item?.url).into(imageView)
    }

}