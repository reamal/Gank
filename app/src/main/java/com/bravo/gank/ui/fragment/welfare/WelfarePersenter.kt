package com.bravo.gank.ui.fragment.welfare

import android.util.Log
import com.bravo.gank.data.DataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

/**
 * Created by Administrator on 2017/6/27.
 */
class WelfarePersenter (val welfareViews: WelfareViews,val dataManager: DataManager):AnkoLogger{
    val PAGE_SIZE = 20;
    var pageNumber = 0;
    fun getWelfare() {
      dataManager.getDatas("福利",PAGE_SIZE,pageNumber)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe {
                  welfareViews.showResult(it.results)
              }
    }

    fun loadData() {
        pageNumber++
        dataManager.getDatas("福利",PAGE_SIZE,pageNumber)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    welfareViews.showResult(it.results)
                }

    }

}