package com.technofreak.testtecyclerretrofit

import android.util.Log
import com.technofreak.testtecyclerretrofit.api.Api
import com.technofreak.testtecyclerretrofit.models.BLog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit_builder {
    companion object {
        fun createDataSet(): ArrayList<BLog> {
            val list = ArrayList<BLog>()
            lateinit var blogg: BLog

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/ ")
                .build()

            val api = retrofit.create(Api::class.java)

            val mycall: Call<List<BLog>> = api.getUsers()

            //background call
            mycall.enqueue(object : Callback<List<BLog>> {
                override fun onFailure(call: Call<List<BLog>>, t: Throwable) {
                    Log.i("DEBUG", "EROOR ON FAILURE RETROFIT")

                }

                override fun onResponse(call: Call<List<BLog>>, response: Response<List<BLog>>) {

                    val Blogs: List<BLog> = response.body()!!
                    var i :Int =1
                    for (blog in Blogs) {

                        Log.i("DEBUGme id",blog.id)

                        blogg = BLog(blog.title, blog.body, blog.id)
                        list.add(blogg)
                    }
                }

            })

            return list
        }
    }
}
