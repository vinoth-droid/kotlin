package com.hcl.kotlinpoc.viewholders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hcl.kotlinpoc.R
import com.hcl.kotlinpoc.models.AboutItem

import kotlinx.android.synthetic.main.about_view_item.view.*

class AboutCanadaRecyclerViewHolder(view: View, context: Context) : RecyclerView.ViewHolder(view) {

    private var context: Context? = null

    init {
        this.context = context
    }

    companion object {
        fun newInstance(viewGroup: ViewGroup, context: Context): AboutCanadaRecyclerViewHolder {
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            val view: View = layoutInflater.inflate(R.layout.about_view_item, viewGroup, false)

            return AboutCanadaRecyclerViewHolder(view, context)
        }
    }

    fun updateView(aboutItem: AboutItem) {
        itemView.aboutItemTitle.text = aboutItem.getTitle()
        itemView.aboutItemDescription.text = aboutItem.getDescription()

        val requestOptions = RequestOptions()
        requestOptions.placeholder(R.drawable.ic_cityscape)
        requestOptions.error(R.drawable.ic_cityscape)

        Glide.with(this.context!!).setDefaultRequestOptions(requestOptions)
                .load(aboutItem.getImageUrl())
                .into(itemView.aboutItemImage)
    }
}