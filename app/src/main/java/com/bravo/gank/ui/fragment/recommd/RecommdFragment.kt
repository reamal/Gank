package com.bravo.gank.ui.fragment.recommd

import android.os.Bundle
import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.BaseFragment

/**
 * Created by Administrator on 2017/6/29.
 */
class RecommdFragment : BaseFragment(),RecommdView {

    companion object {
        lateinit var recommdFragment: RecommdFragment
        fun newInstance(date: String): RecommdFragment {
            val fragment: RecommdFragment = RecommdFragment()
            val args: Bundle = Bundle()
            if (!date.isEmpty()) {
                args.putString("date", date)
            }
            fragment.arguments = args
            return fragment
        }
    }

    lateinit var date: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        date = arguments.getString("date")
    }

    override fun initViews(view: View?) {

    }

    override fun attachLayoutId(): Int = R.layout.fragment_recommend

    override fun setUpComponent(appComponent: AppComponent) {
       DaggerRecommdComponent.builder().appComponent(appComponent).recommdModules(RecommdModules(this)).build().inject(this)
    }
}