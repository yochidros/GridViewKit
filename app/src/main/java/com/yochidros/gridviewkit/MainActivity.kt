package com.yochidros.gridviewkit

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.yochidros.gridviewkitcore.GridAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        grid_view.adapter = GridAdapter(this, createItems(), CustomGridEmpty(), GridAdapter.HORIZONTAL, 3, 3)

    }

    private fun createItems(): List<GridContent> {
        val items: MutableList<GridContent> = mutableListOf()

        (0 until 4).forEach { index ->
            items.add(GridContent(index))
        }
        return items
    }

}
