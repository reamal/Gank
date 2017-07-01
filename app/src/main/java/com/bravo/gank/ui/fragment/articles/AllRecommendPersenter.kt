package com.bravo.gank.ui.fragment.articles

import com.bravo.gank.data.DataManager
import com.bravo.gank.data.PublishedDate
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by Administrator on 2017/7/1.
 */

class AllRecommendPersenter(val allRecommendView:AllRecommendViews,val dataManager:DataManager){

    fun loadPublisheDate() {
        dataManager.loadPublisheDate()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { allRecommendView.startLoading() }
                .subscribe({
                    result -> allRecommendView.setUpView(parseResult(result))
                },{},{
                    allRecommendView.stopLoading()
                })
    }

    private fun parseResult(result: PublishedDate):String{

       var pulished:String
        if (result.error || result.results == null || result.results.size == 0) {
            pulished  = SimpleDateFormat("yyyy/MM/dd").format(Date())
            return pulished
        }
        pulished = result.results[0].replace("-","/")
        return pulished
    }

}
