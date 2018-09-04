package com.yochidros.gridviewkitcore

import android.content.Context
import android.view.LayoutInflater
import android.view.View

open class GridEmpty<V>(val empty: V? = null): Gridable<V> {
    override var resourceId: Int
        get() = R.layout.item_grid_empty
        set(value) {}

    override var value: V?
        get() = null
        set(value) {}

    override fun bind(itemView: View) = Unit

    override fun getInflatedView(context: Context): View = LayoutInflater.from(context).inflate(resourceId, null)
}
