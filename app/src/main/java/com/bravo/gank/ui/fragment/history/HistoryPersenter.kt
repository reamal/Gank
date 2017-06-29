package com.bravo.gank.ui.fragment.history

import com.bravo.gank.data.DataManager
import com.bravo.gank.data.History
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

/**
 * Created by Administrator on 2017/6/27.
 */
class HistoryPersenter(val historyView: HistoryView, val dataManager: DataManager) {
    fun getHistory() {
        dataManager.getHistory()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { historyView.startLoading() }
                .doOnError { historyView.stopLoading() }
                .subscribe {
                    historyView.stopLoading()
                    historyView.showHistory(parseHtml(it.string()))
                }

    }

    private fun parseHtml(html: String): List<History> {
        val doc: Document = Jsoup.parse(html)
        val typo: Elements = doc.getElementsByClass("typo")
        val data: MutableList<History> = arrayListOf()
        var history: History
        typo.select("a").listIterator().forEach {
            history = History(it.attr("href").substring(1), it.text())
            data.add(history)
        }
        return data
    }


}