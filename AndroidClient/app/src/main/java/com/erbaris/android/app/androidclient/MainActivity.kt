package com.erbaris.android.app.androidclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.erbaris.android.app.androidclient.api.IMovieByYearSearch
import com.erbaris.android.app.androidclient.api.MOVIE_BASE_URL
import com.erbaris.android.app.androidclient.data.entity.Movies
import com.erbaris.android.app.movieclient.R
import com.karandev.util.retrofit.RetrofitUtil
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findByYearButtonClicked()
    }
    fun findByYearButtonClicked()
    {
        val movieByYearSearch = RetrofitUtil.createRetrofitClient(MOVIE_BASE_URL).create(
            IMovieByYearSearch::class.java)
        val call = movieByYearSearch.findByYear("2021")
        call.enqueue(object: Callback<Movies> {
            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                val movies = response.body()

                if(movies != null){
                    val movieNames = movies.movies.map { it.name + it.sceneDate.toString() + it.cost}.toString()
                    Toast.makeText(this@MainActivity, movieNames, Toast.LENGTH_LONG).show()
                }
                else
                    Toast.makeText(this@MainActivity, "Problem Occurs", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
                call.cancel()
            }
        })
    }
}