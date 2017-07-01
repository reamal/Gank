package com.bravo.gank.ui.fragment.articles

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import com.bravo.gank.R
import com.bravo.gank.base.AppComponent
import com.bravo.gank.ui.act.MainActivity
import com.bravo.gank.ui.fragment.BaseFragment
import com.bravo.gank.ui.fragment.articles.pages.*
import com.bravo.gank.ui.fragment.recommd.RecommdFragment
import kotlinx.android.synthetic.main.fragment_article_container.*
import java.util.*
import javax.inject.Inject

/**
 * Created by Administrator on 2017/7/1.
 */
class AllRecommendFragment : BaseFragment(),AllRecommendViews{

    @Inject
    lateinit var allRecommendPersenter:AllRecommendPersenter

    override fun initViews(view: View?) {}

    override fun attachLayoutId(): Int=R.layout.fragment_article_container

    override fun setUpComponent(appComponent: AppComponent) {
        DaggerAllRecommendComponent.builder().appComponent(appComponent).allRecommendModule(AllRecommendModule(this)).build().inject(this)
    }

    var activity: MainActivity? = null

    companion object{
        fun newInstance() : AllRecommendFragment {
            return AllRecommendFragment()
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        allRecommendPersenter.loadPublisheDate()
    }

    override fun onAttach(zactivity: Activity?) {
        super.onAttach(zactivity)
        this.activity = zactivity as MainActivity?
    }

    override fun onDetach() {
        super.onDetach()
        this.activity = null
    }


    override fun setUpView(pulished:String) {

        val framgments = ArrayList<Fragment>()
        framgments.add(RecommdFragment.newInstance(pulished!!))
        framgments.add(AndroidFragmet.newInstance())
        framgments.add(IOSFragmet.newInstance())
        framgments.add(WebFragmet.newInstance())
        framgments.add(VideoFragmet.newInstance())
        framgments.add(ExpendFragmet.newInstance())

        val title = resources.getStringArray(R.array.title)
        viewPager.adapter =MainAdapter(framgments, title, childFragmentManager)
        viewPager.offscreenPageLimit = 6

        tabLayout.setupWithViewPager(viewPager)
        tabLayout.tabMode = TabLayout.MODE_SCROLLABLE

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.setCurrentItem(tab!!.position, false)
            }

        })

    }
}