package com.bravo.gank.ui.fragment.welfare

import android.util.Log
import com.bravo.gank.data.DataManager
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug
import org.jetbrains.anko.error

/**
 * Created by Administrator on 2017/6/27.
 */
class WelfarePersenter (val welfareViews: WelfareViews,val dataManager: DataManager):AnkoLogger{
    fun test(s: String) {
        Log.d("dataManager","dataManager == null : ${dataManager == null}  and  ${s}")
       debug ( "dataManager == null : ${dataManager == null}  and  ${s}" )

    }
}