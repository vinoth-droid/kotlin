package com.hcl.kotlinpoc.api

import com.hcl.kotlinpoc.models.AboutResponse
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("s/2iodh4vg0eortkl/facts.json")
    fun getAboutContent(): Call<AboutResponse>

}