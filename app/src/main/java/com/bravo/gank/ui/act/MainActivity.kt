package com.bravo.gank.ui.act

import android.os.Bundle
import android.support.v4.app.Fragment
import com.bravo.gank.R
import com.bravo.gank.ui.act.base.BaseActivity
import com.bravo.gank.ui.fragment.articles.ArticlesFragment
import com.bravo.gank.ui.fragment.history.HistoryFragment
import com.bravo.gank.ui.fragment.welfare.WelfareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var lastIndex = -1
    var lastFragment: Fragment? = null
    var historyFragment: HistoryFragment? = null
    var welfareFragment: WelfareFragment? = null
    var articlesFragment: ArticlesFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_recommend -> {
                    changTab(0)
                }
                R.id.action_girl -> {
                    changTab(1)
                }
                R.id.action_history -> {
                    changTab(2)
                }
            }
            true
        }
    }

    fun changTab(index: Int) {
        if (index == lastIndex) {
            return
        }

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (lastFragment != null) {
            fragmentTransaction.hide(lastFragment!!)
        }
        when (index) {
            0 -> {
                articlesFragment = fragmentManager.findFragmentByTag(ArticlesFragment::class.simpleName) as ArticlesFragment?
                if (articlesFragment == null) {
                    articlesFragment = ArticlesFragment.newInstance()
                    fragmentTransaction.add(R.id.container, articlesFragment, ArticlesFragment::class.simpleName)
                } else {
                    fragmentTransaction.show(articlesFragment)
                }
                lastFragment = articlesFragment
            }
            1 -> {
                welfareFragment = fragmentManager.findFragmentByTag(WelfareFragment::class.simpleName) as WelfareFragment?
                if (welfareFragment == null) {
                    welfareFragment = WelfareFragment.newInstance()
                    fragmentTransaction.add(R.id.container, welfareFragment, WelfareFragment::class.simpleName)
                } else {
                    fragmentTransaction.show(welfareFragment)
                }
                lastFragment = welfareFragment
            }
            2 -> {
                historyFragment = fragmentManager.findFragmentByTag(HistoryFragment::class.simpleName) as HistoryFragment?
                if (historyFragment == null) {
                    historyFragment = HistoryFragment.newInstance()
                    fragmentTransaction.add(R.id.container, historyFragment, HistoryFragment::class.simpleName)
                } else {
                    fragmentTransaction.show(historyFragment)
                }
                lastFragment = historyFragment
            }
        }
        fragmentTransaction.commit()
    }
}
