package com.example.exampleretrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var rvListaRepos: RecyclerView
    private lateinit var adapter: ListaReposAdapter

    private val service: GitHubService = RetrofitManager().services

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvListaRepos = findViewById(R.id.rvListaRepos)
        rvListaRepos.layoutManager = LinearLayoutManager(this)

        getReposGithub()
    }

    private fun getReposGithub() {
        val call = service.getRepos("xcheko51x")
            .enqueue(object : Callback<List<ReposResponse>> {
                override fun onResponse(
                    call: Call<List<ReposResponse>>,
                    response: Response<List<ReposResponse>>
                ) {
                    if (response.body() != null) {
                        val listRepos = response.body()
                        listRepos?.forEach {
                            println(
                                it.nameRepo.plus("\n")
                            )

                            adapter = ListaReposAdapter(listRepos)
                            rvListaRepos.adapter = adapter
                        }


                    }
                }

                override fun onFailure(call: Call<List<ReposResponse>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}