package com.technofreak.testtecyclerretrofit.api


import com.technofreak.testtecyclerretrofit.models.BLog
import retrofit2.Call
import retrofit2.http.GET

//https://jsonplaceholder.typicode.com/      posts
interface Api {
@GET(value = "posts")
    fun getUsers(): Call<List<BLog>>
}