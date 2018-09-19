package com.hcl.kotlinpoc

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.hcl.kotlinpoc.adapters.AboutCanadaRecyclerAdapter
import com.hcl.kotlinpoc.contract.AboutCanadaContract
import com.hcl.kotlinpoc.models.AboutItem
import com.hcl.kotlinpoc.presenters.AboutCanadaPresenter
import kotlinx.android.synthetic.main.activity_about_canada.*

class MainActivity : AppCompatActivity(), AboutCanadaContract.View {

    private var presenter: AboutCanadaPresenter? = null
    private var aboutCanadaRecyclerAdapter: AboutCanadaRecyclerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_canada)

        presenter = AboutCanadaPresenter(this)

        aboutCanadaRecyclerAdapter = AboutCanadaRecyclerAdapter(this)
        aboutRecyclerView.adapter = aboutCanadaRecyclerAdapter

        aboutRecyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout.setOnRefreshListener { getContents(true) }

        getContents(false)
    }

    override fun onResume() {
        super.onResume()
        presenter!!.onViewActive(this)
    }

    override fun onPause() {
        super.onPause()
        presenter!!.onViewInactive()
    }

    override fun updateToolbarTitle(title: String) {
        aboutListToolbar.title = title
    }

    override fun showNoContentInfo() {
        noContentAvailable.visibility = View.VISIBLE
        aboutRecyclerView.visibility = View.GONE
    }

    override fun hideNoContentInfo() {
        noContentAvailable.visibility = View.GONE
        aboutRecyclerView.visibility = View.VISIBLE
    }

    override fun showProgressBar() {
        aboutProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        aboutProgressBar.visibility = View.GONE
    }

    override fun updateListView(items: List<AboutItem>) {
        aboutCanadaRecyclerAdapter?.setContent(items)
    }

    override fun setSwipeTopProgressBar(isVisible: Boolean) {
        swipeRefreshLayout.isRefreshing = false

    }

    private fun getContents(isRefresh: Boolean) {
        presenter!!.getContent(isRefresh)
    }
}
