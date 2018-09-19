package com.hcl.kotlinpoc.presenters

import android.support.annotation.NonNull

open class BasePresenter<VIEW_TYPE> : ViewStatePresenter<VIEW_TYPE> {

    protected var view: VIEW_TYPE? = null

    override fun onViewActive(@NonNull view: VIEW_TYPE) {
        this.view = view
    }

    override fun onViewInactive() {
        this.view = null
    }

}