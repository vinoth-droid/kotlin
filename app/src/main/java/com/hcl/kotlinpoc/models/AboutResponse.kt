package com.hcl.kotlinpoc.models

import com.google.gson.annotations.SerializedName

class AboutResponse(title: String, aboutItems: List<AboutItem>) {

    @SerializedName("title")
    private var title: String = ""

    @SerializedName("rows")
    private var aboutItems: List<AboutItem> = ArrayList()

    init {
        this.title = title
        this.aboutItems = aboutItems
    }

    fun getTitle(): String {
        return this.title
    }

    fun getAboutItems(): List<AboutItem>? {
        return this.aboutItems
    }
}