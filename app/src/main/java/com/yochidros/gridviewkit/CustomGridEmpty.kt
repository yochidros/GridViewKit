package com.yochidros.gridviewkit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.yochidros.gridviewkitcore.GridEmpty

class CustomGridEmpty<V> : GridEmpty<V>() {
    override var value: V?
        get() = super.value
        set(value) {}

    override var resourceId: Int = R.layout.item_grid_emtpy

    override fun getInflatedView(context: Context): View = LayoutInflater.from(context).inflate(resourceId, null)

    override fun bind(itemView: View) = Unit
}