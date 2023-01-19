package com.erbaris.android.app.androidclient.viewmodel.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.erbaris.android.app.androidclient.data.entity.Movie

class MovieListAdapter (context: Context,
                        items: MutableList<Movie> = arrayListOf())
    : ArrayAdapter<Movie>(context, android.R.layout.simple_list_item_1, items){
        override fun add(mo: Movie?)
        {
            super.add(mo)
            notifyDataSetChanged()
        }
}