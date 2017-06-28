package com.bravo.gank.data.local

import android.util.Log
import com.bravo.gank.data.IDataSource
import com.bravo.gank.data.Result
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Administrator on 2017/6/27.
 */
class LocalDataSource :IDataSource{
    override fun getDatas(type: String, pageSize: Int, pageNumber: Int): Observable<Result> {
        Log.e(LocalDataSource::class.simpleName,"LocalDataSource")
        return Observable.just(Result(false, arrayListOf()))
    }
}