package com.bravo.gank.data.source

import com.bravo.gank.data.Api.GankService
import com.bravo.gank.data.BASE_URL
import com.bravo.gank.data.DataManager
import com.bravo.gank.data.IDataSource
import com.bravo.gank.data.local.LocalDataSource
import com.bravo.gank.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

/**
 * Created by Administrator on 2017/6/27.
 */
@Module
class DataSourceModule {

    @Provides
    fun provideGankService():GankService{
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(GankService::class.java)
    }

    @Named(value = "remote")
    @Provides
    fun provideRemoteDataSource(gankService: GankService): IDataSource {
        return RemoteDataSource(gankService)
    }
    @Named(value = "local")
    @Provides
    fun provideLocalDataSource(): IDataSource {
        return LocalDataSource()
    }

    @Provides
    fun provideDataManager(@Named(value = "local") local: IDataSource,@Named(value = "remote") remote: IDataSource): DataManager {
        return DataManager(local, remote)
    }
}