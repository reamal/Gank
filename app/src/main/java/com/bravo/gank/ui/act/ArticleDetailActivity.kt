package com.bravo.gank.ui.act

import android.graphics.Bitmap
import android.net.http.SslError
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.SslErrorHandler
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bravo.gank.R
import kotlinx.android.synthetic.main.activity_article_detail.*

class ArticleDetailActivity : AppCompatActivity() {

    var title: String =""
    var url : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
        initData()
        initView()
    }

    private fun initData(){
        title = intent.getStringExtra("desc")
        url = intent.getStringExtra("url")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    private fun initView() {
        setSupportActionBar(toolbar)
        supportActionBar?.title = title
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true

//        webView.webViewClient = object : WebViewClient(){
//
//            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
//                view?.loadUrl(url)
//                return true
//            }
//
//            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
//                handler?.proceed()
//            }
//
//            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
////                showProgress()
//                super.onPageStarted(view, url, favicon)
//            }
//
//            override fun onPageFinished(view: WebView?, url: String?) {
////                dimssProgress()
//                super.onPageFinished(view, url)
//
//            }
//        }

        webView.setWebViewClient(object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url)
                return true
            }

            override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
                handler?.proceed()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//                showProgress()
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
//                dimssProgress()
                super.onPageFinished(view, url)

            }
        })

        webView.loadUrl(url)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
                return true
            } else -> return super.onOptionsItemSelected(item)
        }
    }
}
