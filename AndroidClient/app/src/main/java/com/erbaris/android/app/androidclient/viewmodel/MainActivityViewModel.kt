package com.erbaris.android.app.androidclient.viewmodel

import com.erbaris.android.app.androidclient.MainActivity

class MainActivityViewModel(var activity: MainActivity) {
    fun startFindByYearButton() = activity.startFindByYear()
    fun exitApp() = activity.exitButtonClickCallback()
}