package com.bravo.gank.data

import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * Created by Administrator on 2017/6/27.
 */
class DataManager(val local: IDataSource,val  remote: IDataSource) {
    fun  getDatas(type: String, pageSize: Int, pageNumber: Int): Observable<Result> {
       return remote.getDatas(type,pageSize,pageNumber).onErrorResumeNext(local.getDatas(type,pageSize,pageNumber))
    }
}