package com.hcl.kotlinpoc.contract

import com.hcl.kotlinpoc.models.AboutItem
import com.hcl.kotlinpoc.presenters.ViewStatePresenter

interface AboutCanadaContract {

    interface Presenter : ViewStatePresenter<View> {
        fun getContent(isRefresh: Boolean)
    }

    interface View {
        fun updateToolbarTitle(title: String)

        fun updateListView(items: List<AboutItem>)

        fun setSwipeTopProgressBar(isVisible: Boolean)

        fun showNoContentInfo()

        fun hideNoContentInfo()

        fun showProgressBar()

        fun hideProgressBar()

    }
}