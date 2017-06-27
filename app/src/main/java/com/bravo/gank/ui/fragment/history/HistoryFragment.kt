package com.bravo.gank.ui.fragment.history

import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.BaseFragment

/**
 * Created by Administrator on 2017/6/26.
 */
class HistoryFragment : BaseFragment(){
    override fun attachLayoutId(): Int = R.layout.fragment_history

    companion object{
        fun newInstance(): HistoryFragment {
            return  HistoryFragment()
        }
    }

    override fun initViews(view: View) {
    }

    override fun setUpComponent(appComponent: AppComponent) {
    }

}