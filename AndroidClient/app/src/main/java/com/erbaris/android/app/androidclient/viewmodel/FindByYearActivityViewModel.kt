package com.erbaris.android.app.androidclient.viewmodel

import com.erbaris.android.app.androidclient.FindByYearActivity
import com.erbaris.android.app.androidclient.data.entity.Movie
import com.erbaris.android.app.androidclient.viewmodel.adapter.MovieListAdapter

class FindByYearActivityViewModel(var activity: FindByYearActivity, var year: String = "", var adapter: MovieListAdapter = MovieListAdapter(activity)) {
    fun searchButton() = activity.findByYearButtonClicked()
}