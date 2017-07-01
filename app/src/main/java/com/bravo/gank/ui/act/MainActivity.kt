package com.bravo.gank.ui.act

import android.os.Bundle
import android.support.v4.app.Fragment
import com.bravo.gank.R
import com.bravo.gank.ui.act.base.BaseActivity
import com.bravo.gank.ui.fragment.articles.AllRecommendFragment
import com.bravo.gank.ui.fragment.history.HistoryFragment
import com.bravo.gank.ui.fragment.welfare.WelfareFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    var lastIndex = -1
    var lastFragment: Fragment? = null
    var historyFragment: HistoryFragment? = null
    var welfareFragment: WelfareFragment? = null
    var allRecommendFragment: AllRecommendFragment? = null
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
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        if (allRecommendFragment == null) {
            allRecommendFragment = AllRecommendFragment.newInstance()
            fragmentTransaction.add(R.id.container, allRecommendFragment, AllRecommendFragment::class.simpleName)
        } else {
            fragmentTransaction.show(allRecommendFragment)
        }
        lastFragment = allRecommendFragment
        fragmentTransaction.commit()
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
                allRecommendFragment = fragmentManager.findFragmentByTag(AllRecommendFragment::class.simpleName) as AllRecommendFragment?
                if (allRecommendFragment == null) {
                    allRecommendFragment = AllRecommendFragment.newInstance()
                    fragmentTransaction.add(R.id.container, allRecommendFragment, AllRecommendFragment::class.simpleName)
                } else {
                    fragmentTransaction.show(allRecommendFragment)
                }
                lastFragment = allRecommendFragment
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
