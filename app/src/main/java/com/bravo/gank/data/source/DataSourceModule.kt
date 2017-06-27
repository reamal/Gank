package com.bravo.gank.data.source

import com.bravo.gank.data.DataManager
import com.bravo.gank.data.IDataSource
import com.bravo.gank.data.local.LocalDataSource
import com.bravo.gank.data.remote.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by Administrator on 2017/6/27.
 */
@Module
class DataSourceModule {

    @Named(value = "remote")
    @Provides
    fun provideRemoteDataSource(): IDataSource {
        return RemoteDataSource()
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