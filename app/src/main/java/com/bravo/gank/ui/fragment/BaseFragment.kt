package com.bravo.gank.ui.fragment

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bravo.gank.base.AppComponent
import com.bravo.gank.base.BaseApp
import org.jetbrains.anko.support.v4.indeterminateProgressDialog

/**
 * Created by Administrator on 2017/6/26.
 */
abstract class BaseFragment : Fragment(), IViews {

    var progressDialog: ProgressDialog? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater?.inflate(attachLayoutId(), container, false)
        setUpComponent(BaseApp.getApp().getAppComponent())
        initViews(view)
        return view
    }

    override fun startLoading() {
        if (null === progressDialog){
            progressDialog = indeterminateProgressDialog("正在加载...")
        }else{
            progressDialog?.show()
        }
    }

    override fun stopLoading() {
        progressDialog?.dismiss()
    }

    override fun onDetach() {
        super.onDetach()
        stopLoading()
    }

    abstract fun initViews(view: View?)
    abstract fun attachLayoutId(): Int
    abstract fun setUpComponent(appComponent: AppComponent)
}