package com.hcl.kotlinpoc.models

import com.google.gson.annotations.SerializedName

class AboutItem(title: String, description: String, imageUrl: String) {

    @SerializedName("title")
    private var title: String = ""

    @SerializedName("description")
    private var description: String = ""

    @SerializedName("imageHref")
    private var imageUrl: String = ""

    init {
        this.title = title
        this.description = description
        this.imageUrl = imageUrl
    }

    fun getTitle(): String {
        return this.title
    }

    fun getDescription(): String {
        return this.description
    }

    fun getImageUrl() : String {
        return this.imageUrl
    }
}