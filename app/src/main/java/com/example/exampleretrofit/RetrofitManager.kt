package com.example.exampleretrofit

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.logging.Level

class RetrofitManager {

    val client: OkHttpClient = OkHttpClient.Builder()
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.github.com/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val services: GitHubService = retrofit.create(GitHubService::class.java)
}

interface GitHubService {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Call<List<ReposResponse>>
}