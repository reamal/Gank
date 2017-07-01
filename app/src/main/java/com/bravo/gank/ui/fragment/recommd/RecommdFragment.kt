package com.bravo.gank.ui.fragment.recommd

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.data.Article
import com.bravo.gank.ui.act.ArticleDetailActivity
import com.bravo.gank.ui.fragment.BaseFragment
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_recommend.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Administrator on 2017/6/29.
 */
class RecommdFragment : BaseFragment(),RecommdView,AnkoLogger {

    @Inject
    lateinit var recommdPersenter:RecommdPersenter
    @Inject
    lateinit var recommendAdapter:RecommendAdapter


    companion object {
        lateinit var recommdFragment: RecommdFragment
        fun newInstance(date: String): RecommdFragment {
            recommdFragment= RecommdFragment()
            val args: Bundle = Bundle()
            if (!date.isEmpty()) {
                args.putString("date", date)
            }
            recommdFragment.arguments = args
            return recommdFragment
        }
    }

    lateinit var date: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        date = arguments.getString("date")
    }

    override fun initViews(view: View?) {
       recommdPersenter.getDataByDate(date)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.isNestedScrollingEnabled = false
        recyclerView.adapter=recommendAdapter
        recommendAdapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->

            activity?.toast("item Onclick ${position}")
            start2DetailAcivity(adapter.getItem(position) as Article)
        }
    }

    override fun attachLayoutId(): Int = R.layout.fragment_recommend

    override fun setUpComponent(appComponent: AppComponent) {
       DaggerRecommdComponent.builder().appComponent(appComponent).recommdModules(RecommdModules(this)).build().inject(this)
    }

    override fun setUpView(parseRsult: List<Article>?) {
        recommendAdapter.setNewData(parseRsult)
    }

    override fun setWelfImage(imageUrl: String) {
        Glide.with(this)
                .load(imageUrl)
                .into(welFare)
    }

    private fun start2DetailAcivity(article: Article) {
        val intent = Intent(activity, ArticleDetailActivity::class.java)
        intent.putExtra("desc",article.desc)
        intent.putExtra("url", article.url)
        activity?.startActivity(intent)
    }
}