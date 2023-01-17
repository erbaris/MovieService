package com.erbaris.android.app.androidclient

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.erbaris.android.app.androidclient.api.IMovieByYearSearch
import com.erbaris.android.app.androidclient.api.MOVIE_BASE_URL
import com.erbaris.android.app.androidclient.data.entity.Movies
import com.erbaris.android.app.androidclient.databinding.ActivityMainBinding
import com.erbaris.android.app.androidclient.viewmodel.MainActivityViewModel
import com.erbaris.android.app.androidclient.R
import com.karandev.util.retrofit.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.viewModel = MainActivityViewModel(this)

    }

    private fun init()
    {
        initBinding()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()

    }
    fun startFindByYear()
    {
        Intent(this, FindByYearActivity::class.java).apply { startActivity(this) }
    }

    fun exitButtonClickCallback()
    {
        Toast.makeText(this, R.string.message_text_goodbye, Toast.LENGTH_LONG).show()
        finish()
    }
}