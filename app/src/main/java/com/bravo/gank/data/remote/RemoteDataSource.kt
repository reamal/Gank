package com.bravo.gank.data.remote

import android.util.Log
import com.bravo.gank.data.Api.GankService
import com.bravo.gank.data.IDataSource
import com.bravo.gank.data.Result
import com.bravo.gank.data.local.LocalDataSource
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * Created by Administrator on 2017/6/27.
 */
class RemoteDataSource(val gankService: GankService) : IDataSource {

    override fun getHistory(): Observable<ResponseBody> {
        return gankService.getHistory()
    }

    override fun getDatas(type: String, pageSize: Int, pageNumber: Int): Observable<Result> {
        Log.e(RemoteDataSource::class.simpleName,"RemoteDataSource")
        return gankService.getDatas(type, pageSize, pageNumber)
    }
}