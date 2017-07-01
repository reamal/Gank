package com.bravo.gank.ui.fragment.articles.pages.base

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.data.Article
import com.bravo.gank.ui.act.ArticleDetailActivity
import com.bravo.gank.ui.fragment.BaseFragment
import com.chad.library.adapter.base.BaseQuickAdapter
import kotlinx.android.synthetic.main.fragment_base.*
import javax.inject.Inject

/**
 * Created by Administrator on 2017/6/26.
 */
abstract class ArticlesFragment: BaseFragment(), ArticlesViews {
    override fun attachLayoutId(): Int= R.layout.fragment_base

    @Inject
    lateinit var articlesPersenter: ArticlesPersenter

    var isLoadMore:Boolean = false

    override fun initViews(view: View?) {}

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isLoadMore = false
        articlesPersenter.getData(getType())
        initRecyclerView()
        swipeLayout.isRefreshing = false
        swipeLayout.setColorSchemeResources(R.color.colorAccent)
        swipeLayout.setOnRefreshListener {
            swipeLayout.isRefreshing = true
            isLoadMore = false
            articlesPersenter.getData(getType())
        }
    }

    abstract fun getType():String

    override fun showResult(results: List<Article>){
        if (isLoadMore){
            adapter?.addData(results)
            adapter?.loadMoreComplete()
        }else{
            adapter?.setNewData(results)
            swipeLayout.isRefreshing = false
        }
    }
    override fun setUpComponent(appComponent: AppComponent) {
        DaggerArticlesComponent.builder().appComponent(appComponent).articlesModule(ArticlesModule(this)).build().inject(this)
    }

    var adapter:ArticleAdapter? = null

    fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        adapter = ArticleAdapter(activity?.applicationContext, R.layout.item_article)
        recyclerView.adapter = adapter

        adapter?.setOnLoadMoreListener({
            isLoadMore = true
            articlesPersenter.loadMore(getType())
        },recyclerView)
        adapter?.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            start2DetailAcivity(adapter.data[position] as Article)
        }
    }

    private fun start2DetailAcivity(article: Article) {
        val intent = Intent(activity, ArticleDetailActivity::class.java)
        intent.putExtra("desc",article.desc)
        intent.putExtra("url", article.url)
        activity?.startActivity(intent)
    }
}