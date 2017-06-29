package com.bravo.gank.ui.fragment.welfare

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.data.Article
import com.bravo.gank.ui.act.PhotoActivity
import com.bravo.gank.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_history.*
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by Administrator on 2017/6/26.
 */
class WelfareFragment : BaseFragment(), WelfareViews {


    override fun attachLayoutId(): Int = R.layout.fragment_girl
    @Inject
    lateinit var welfarePersenter: WelfarePersenter
    @Inject
    lateinit var adapter: WelfareAdapter

    var isRefresh: Boolean = true

    companion object {
        fun newInstance(): WelfareFragment {
            return WelfareFragment()
        }
    }

    override fun initViews(view: View?) {
        welfarePersenter.getWelfare()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val recyclerView = view?.find<RecyclerView>(R.id.recyclerView)
        toolbar.visibility = View.VISIBLE
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener { adapter, view, position ->
            start2PhotoAcivity(adapter.getItem(position) as Article)
        }
        adapter.setOnLoadMoreListener({
            isRefresh = false
            welfarePersenter.loadData()
        }, recyclerView)
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerWelfareComponent.builder().appComponent(appComponent).welfareModule(WelfareModule(this)).build().inject(this)
    }

    override fun showResult(it: List<Article>) {
        if (isRefresh) {
            adapter.setNewData(it)
        } else {
            adapter.addData(it)
            adapter.loadMoreComplete()
        }
    }

    private fun start2PhotoAcivity(article:Article) {
        val intent = Intent(activity, PhotoActivity::class.java)
        intent.putExtra("url",article.url)
        activity?.startActivity(intent)
    }

}