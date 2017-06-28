package com.bravo.gank.data.Api

import com.bravo.gank.data.Result
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Administrator on 2017/6/28.
 */
interface GankService{

//    @GET("data/{type}/{pageSize}/{pageNumber}")
//    fun getDatas(@Path("type") type: String,
//                 @Path("pageSize") pageSize: Int,
//                 @Path("pageNumber") pageNumber: Int):Flowable<Result>
    @GET("data/{type}/{pageSize}/{pageNumber}")
    fun getDatas(@Path("type") type: String,
                 @Path("pageSize") pageSize: Int,
                 @Path("pageNumber") pageNumber: Int): Observable<Result>

//            @GET("/search/users")
//    fun getUsers(@Query("q")key :String):Flowable<Users>
}