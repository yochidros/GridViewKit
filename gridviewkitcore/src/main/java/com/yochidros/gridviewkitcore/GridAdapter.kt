package com.yochidros.gridviewkitcore

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class GridAdapter<V, G: Gridable<V>> : BaseAdapter {
    companion object {
        val HORIZONTAL = 1
        val VERTICAL = 1
    }

    private var numColumns: Int = 0
    private var numRows: Int = 0
    private val context: Context
    private var orientation: Int = HORIZONTAL
    private val items: List<G>
    private val emptyItem: GridEmpty<V>?

    constructor(context: Context, items: List<G>, emptyItem: GridEmpty<V>? = null, orientation: Int, columns: Int, rows: Int) {
        this.context = context
        this.items = items
        this.numColumns = columns
        this.numRows = rows
        this.orientation = orientation
        this.emptyItem = emptyItem
        init()
    }

    private var contents: ArrayList<G> = arrayListOf()
    private var rows: ArrayList<List<G>> = arrayListOf()

    private fun init() {
        if (orientation == VERTICAL) {
            for(index in 0 until numRows) {
                var row: MutableList<G> = items.filterIndexed( { i, item ->
                    i % numRows == index
                }).toMutableList()
                if (row.size != numColumns) {
                    val emptySize = numColumns - row.size
                    (0 until emptySize).forEach {
                        if (emptyItem != null ) {
                            row.add(emptyItem as G)
                        } else {
                            val empty = GridEmpty(null) as G
                            row.add(empty)
                        }
                    }
                }
                contents.addAll(row)
            }
        } else {
            rows.add(items)
        }
    }

    override fun getCount(): Int {
        if(orientation == VERTICAL) {
            return numColumns * numRows
        } else {
            return items.size
        }
    }

    override fun getItem(position: Int): Any {
        if (orientation == VERTICAL) {
            return contents[position]
        } else {
            return items[position]
        }
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item: G
        if (orientation == VERTICAL) {
            item = contents[position]
        } else {
            item = items[position]
        }
        return item.getInflatedView(context).apply {
            item.bind(this)
        }
    }
}