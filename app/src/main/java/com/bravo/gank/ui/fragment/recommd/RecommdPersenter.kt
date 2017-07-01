package com.bravo.gank.ui.fragment.recommd

import com.bravo.gank.data.Article
import com.bravo.gank.data.DataManager
import com.bravo.gank.data.Type
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject

/**
 * Created by Administrator on 2017/6/29.
 */
class RecommdPersenter(val recommdView: RecommdView, val dataManager: DataManager) {

    lateinit var imageUrl: String

    fun getDataByDate(date: String) {
        dataManager.getDataByDate(date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { recommdView.startLoading() }
                .doOnError { recommdView.stopLoading() }
                .subscribe {
                    recommdView.stopLoading()
                    recommdView.setUpView(parseRsult(it.string()))
                    recommdView.setWelfImage(imageUrl)
                }
    }

    private fun parseRsult(result: String): List<Article>? {
        val jsonObject = JSONObject(result)
        val error = jsonObject.getBoolean("error")
        if (error) {
            return null
        }
        val results = jsonObject.getJSONObject("results")
        val data: MutableList<Article> = arrayListOf()

        val gson = Gson()

        val type = object : TypeToken<List<Article>>() {}.type
        results.keys().forEach {
            if (it != Type.福利.name) {
                data.addAll(gson.fromJson<List<Article>>(results.getJSONArray(it).toString(), type))
            } else {
                val array = results.getJSONArray(it)
                if (array.length() >= 0) {
                    imageUrl = array.getJSONObject(0).getString("url")
                }
            }
        }
        return data
    }
}