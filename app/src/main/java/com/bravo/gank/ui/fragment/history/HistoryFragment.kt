package com.bravo.gank.ui.fragment.history

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.data.History
import com.bravo.gank.ui.act.base.HistoryDateActivity
import com.bravo.gank.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_history.*
import javax.inject.Inject

/**
 * Created by Administrator on 2017/6/26.
 */
class HistoryFragment : BaseFragment(), HistoryView {

    override fun showHistory(parseHtml: List<History>) {
        historyAdapter.setNewData(parseHtml)
    }

    override fun attachLayoutId(): Int = R.layout.fragment_history

    @Inject
    lateinit var historyPersenter: HistoryPersenter
    @Inject
    lateinit var historyAdapter: HistoryAdapter

    companion object {
        fun newInstance(): HistoryFragment {
            return HistoryFragment()
        }
    }

    override fun initViews(view: View?) {
        historyPersenter.getHistory()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.visibility = View.VISIBLE
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = historyAdapter
        historyAdapter.setOnItemClickListener { adapter, view, position ->
            val history = adapter.getItem(position) as History
            start2HistoryAcivity(history.date)
        }
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerHistoryComponent.builder().appComponent(appComponent).historyModule(HistoryModule(this)).build().inject(this)
    }

    private fun start2HistoryAcivity(date: String) {
        val intent = Intent(activity, HistoryDateActivity::class.java)
        intent.putExtra("date",date)
        activity?.startActivity(intent)
    }

}