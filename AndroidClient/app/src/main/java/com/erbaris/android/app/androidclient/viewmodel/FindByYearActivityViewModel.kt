package com.erbaris.android.app.androidclient.viewmodel

import com.erbaris.android.app.androidclient.FindByYearActivity

class FindByYearActivityViewModel(var activity: FindByYearActivity) {
    fun searchButton() = activity.findByYearButtonClicked()
}