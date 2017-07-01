package com.bravo.gank.data

import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 * Created by Administrator on 2017/6/27.
 */
interface IDataSource {
    fun  getDatas(type: String, pageSize: Int, pageNumber: Int): Observable<Result>
    fun  getHistory(): Observable<ResponseBody>
    fun  getDataByDate(date: String): Observable<ResponseBody>
    fun  loadPublisheDate(): Observable<PublishedDate>
}