package com.yochidros.gridviewkitcore

import android.content.Context
import android.view.View

interface Gridable<Value>{
    var value: Value?
    var resourceId: Int

    fun getInflatedView(context: Context): View
    fun bind(itemView: View)

}