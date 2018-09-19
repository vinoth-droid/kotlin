package com.hcl.kotlinpoc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIClient private constructor() {

    private object RetrofitObj {
        val INSTANCE: Retrofit = Retrofit.Builder().baseUrl("https://dl.dropboxusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    companion object {
        fun getClient(): Retrofit {
            return RetrofitObj.INSTANCE
        }
    }
}