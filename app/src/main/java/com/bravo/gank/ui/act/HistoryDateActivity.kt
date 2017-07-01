package com.bravo.gank.ui.act

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

import com.bravo.gank.R
import com.bravo.gank.ui.fragment.recommd.RecommdFragment
import kotlinx.android.synthetic.main.activity_history_date.*

class HistoryDateActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_date)
        val date = intent.getStringExtra("date")
        initToolBar(date)
        addContainer(date)
    }

    private fun addContainer(date:String) {
        supportFragmentManager.beginTransaction()
                .add(R.id.container, RecommdFragment.newInstance(date))
                .commit()
    }

    private fun initToolBar(date: String) {
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = date
        actionBar?.setDisplayHomeAsUpEnabled(true)
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
