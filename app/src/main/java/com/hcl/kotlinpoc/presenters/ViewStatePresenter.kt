package com.hcl.kotlinpoc.presenters

import android.support.annotation.NonNull

interface ViewStatePresenter<VIEW_TYPE> {

    fun onViewActive(@NonNull view: VIEW_TYPE)

    fun onViewInactive()

}