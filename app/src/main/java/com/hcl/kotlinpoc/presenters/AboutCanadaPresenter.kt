package com.hcl.kotlinpoc.presenters

import com.hcl.kotlinpoc.api.APIClient
import com.hcl.kotlinpoc.api.APIService
import com.hcl.kotlinpoc.contract.AboutCanadaContract
import com.hcl.kotlinpoc.models.AboutResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AboutCanadaPresenter(view: AboutCanadaContract.View) : BasePresenter<AboutCanadaContract.View>(), AboutCanadaContract.Presenter {

    private var viewVal: AboutCanadaContract.View? = null

    init {
        this.viewVal = view
    }

    override fun getContent(isRefresh: Boolean) {
        if (!isRefresh) {
            viewVal?.showProgressBar()
        }

        var apiService = APIClient.getClient().create(APIService::class.java)
        val apiCall: Call<AboutResponse> = apiService.getAboutContent()

        apiCall.enqueue(object : Callback<AboutResponse> {
            override fun onFailure(call: Call<AboutResponse>?, t: Throwable?) {
                updateOnViewFailure()
            }

            override fun onResponse(call: Call<AboutResponse>?, response: Response<AboutResponse>?) {
                if (response != null && response.isSuccessful && response.body() != null
                        && response.body()!!.getAboutItems()!!.isNotEmpty()) {
                    updateViewOnSuccess(response)
                } else {
                    updateOnViewFailure()
                }
            }
        })
    }

    fun updateViewOnSuccess(response: Response<AboutResponse>) {
        this.viewVal?.updateToolbarTitle(response.body()!!.getTitle())
        this.viewVal?.updateListView(response.body()!!.getAboutItems()!!)

        this.viewVal?.setSwipeTopProgressBar(false)
        this.viewVal?.hideProgressBar()
        this.viewVal?.hideNoContentInfo()
    }

    fun updateOnViewFailure() {
        this.viewVal?.hideProgressBar()
        this.viewVal?.showNoContentInfo()
        this.viewVal?.setSwipeTopProgressBar(false)
    }
}