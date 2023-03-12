package com.erbaris.android.app.androidclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.erbaris.android.app.androidclient.api.IMovieByYearSearch
import com.erbaris.android.app.androidclient.api.MOVIE_BASE_URL
import com.erbaris.android.app.androidclient.data.entity.Movie
import com.erbaris.android.app.androidclient.data.entity.Movies
import com.erbaris.android.app.androidclient.databinding.ActivityFindByYearBinding
import com.erbaris.android.app.androidclient.viewmodel.FindByYearActivityViewModel
import com.karandev.util.retrofit.RetrofitUtil
import com.karandev.util.retrofit.putQueue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindByYearActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityFindByYearBinding
    private lateinit var mMovieService: IMovieByYearSearch

    private fun initBinding()
    {
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_find_by_year)
        mBinding.viewModel = FindByYearActivityViewModel(this)

    }

    private fun initMovieService()
    {
        mMovieService = RetrofitUtil.createRetrofit(MOVIE_BASE_URL).create(IMovieByYearSearch::class.java)
    }
    private fun init()
    {
        initBinding()
        initMovieService()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    fun findByYearButtonClicked()
    {
        mBinding.viewModel!!.adapter.clear()
        val call = mMovieService.findByYear(mBinding.viewModel!!.year)
        call.putQueue({_, r -> responseCallback(r)}) {c, r -> failCallback(c, r)}
    }




    private fun responseCallback(response: Response<Movies>)
    {
        val mv = response.body()

        if (mv != null)
            if (mv.movies.isNotEmpty())
                mv.movies.forEach { mBinding.viewModel!!.adapter.add(it) }
            else
                Toast.makeText(this, R.string.no_movie_message, Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this, R.string.problem_message, Toast.LENGTH_LONG).show()
    }

    private fun failCallback(call: Call<Movies>, ex: Throwable)
    {
        Toast.makeText(this, R.string.problem_try_again_message, Toast.LENGTH_LONG).show()
        Toast.makeText(this, ex.message!!, Toast.LENGTH_LONG).show()
        Log.d("movies_response", ex.message!!)
        call.cancel()
    }
}