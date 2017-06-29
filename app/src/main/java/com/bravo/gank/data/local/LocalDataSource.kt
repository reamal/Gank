package com.bravo.gank.data.local

import android.util.Log
import com.bravo.gank.data.IDataSource
import com.bravo.gank.data.Result
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * Created by Administrator on 2017/6/27.
 */
class LocalDataSource :IDataSource{

    override fun getHistory(): Observable<ResponseBody> {
      return Observable.just(null)
    }

    override fun getDatas(type: String, pageSize: Int, pageNumber: Int): Observable<Result> {
        return Observable.just(Result(false, arrayListOf()))
    }
}