package com.yochidros.gridviewkit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.yochidros.gridviewkitcore.Gridable
import kotlinx.android.synthetic.main.item_grid_content.view.*

data class GridContent(
        val id: Int
) : Gridable<GridContent> {

    override var resourceId: Int = R.layout.item_grid_content

    override var value: GridContent? = this

    override fun getInflatedView(context: Context): View = LayoutInflater.from(context).inflate(resourceId, null)

    override fun bind(itemView: View) {
        itemView.grid_btn.text = "${id}"
    }
}

