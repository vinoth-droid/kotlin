package com.hcl.kotlinpoc.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.hcl.kotlinpoc.models.AboutItem
import com.hcl.kotlinpoc.viewholders.AboutCanadaRecyclerViewHolder

class AboutCanadaRecyclerAdapter(context: Context) : RecyclerView.Adapter<AboutCanadaRecyclerViewHolder>() {

    private var aboutItems: ArrayList<AboutItem> = ArrayList()
    private var context: Context? = null

    init {
        this.context = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutCanadaRecyclerViewHolder {
        return AboutCanadaRecyclerViewHolder.newInstance(parent, this.context!!)
    }

    override fun getItemCount(): Int {
        return aboutItems.size
    }

    override fun onBindViewHolder(holder: AboutCanadaRecyclerViewHolder, position: Int) {
        holder.updateView(aboutItems[position])
    }

    fun setContent(items: List<AboutItem>) {
        aboutItems = ArrayList()
        aboutItems.addAll(items)
        notifyDataSetChanged()
    }
}