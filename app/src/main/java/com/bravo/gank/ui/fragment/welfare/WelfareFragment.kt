package com.bravo.gank.ui.fragment.welfare

import android.view.View
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.fragment.BaseFragment
import javax.inject.Inject

/**
 * Created by Administrator on 2017/6/26.
 */
class WelfareFragment : BaseFragment(),WelfareViews {

    override fun attachLayoutId(): Int = R.layout.fragment_girl
    @Inject
    lateinit var welfarePersenter:WelfarePersenter

    companion object {
        fun newInstance(): WelfareFragment {
            return WelfareFragment()
        }
    }

    override fun initViews(view: View) {
      welfarePersenter?.test("from fragment")
    }

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerWelfareComponent.builder().appComponent(appComponent).welfareModule(WelfareModule(this)).build().inject(this)
    }

}