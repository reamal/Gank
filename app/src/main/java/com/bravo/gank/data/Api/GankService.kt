package com.bravo.gank.data.Api

import com.bravo.gank.data.Result
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Administrator on 2017/6/28.
 */
interface GankService{


    @GET("api/data/{type}/{pageSize}/{pageNumber}")
    fun getDatas(@Path("type") type: String,
                 @Path("pageSize") pageSize: Int,
                 @Path("pageNumber") pageNumber: Int): Observable<Result>

    @GET("history")
    fun  getHistory(): Observable<ResponseBody>

    @GET("api/day/{date}")
    fun getDataByDate(@Path("date") date:String):Observable<ResponseBody>

}